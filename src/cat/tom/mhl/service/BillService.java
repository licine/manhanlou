package cat.tom.mhl.service;

import cat.tom.mhl.dao.BasicDAO;
import cat.tom.mhl.dao.BillDAO;
import cat.tom.mhl.dao.MenuDAO;
import cat.tom.mhl.domain.Bill;

import java.util.List;
import java.util.UUID;

/**
 * @author shkstart
 * @create 2023-10-21 9:44
 */
public class BillService {

    BillDAO billDAO = new BillDAO();
    MenuService menuService = new MenuService();

    DinningTableService dinningTableService = new DinningTableService();

    // 生成账单, 并修改对应餐桌状态
    public boolean orderMenu(int menuId, int nums, int dinningTableId){

        // 生成账单
        int update = billDAO.update("insert into bill values(null, ?, ?, ?, ?, ?, now(), '未结帐')", UUID.randomUUID().toString(),
                menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, dinningTableId);

        if (update != 1) return false;

        // 修改对应餐桌状态
        return dinningTableService.updateDinningTableState("就餐中", dinningTableId);
    }

    // 返回所有账单
    public List<Bill> list(){
        return billDAO.queryMulti("SELECT * from bill", Bill.class);
    }


    // 确认餐桌是否存在与是否是未结帐的状态
    public boolean hasPayBillByDinningTableId(int dinningTableId){
        Bill bill = billDAO.querySingle("select * FROM bill where state = '未结帐' and dinningTableId = ?",
                Bill.class, dinningTableId);
        return bill != null;
    }

    // 完成结账, 将bill表支付状态改为支付方式，dinningTable表中餐桌状态置空
    public boolean payBill(int dinningTableId, String payWay) {

        // 小bug -- 需要用到事务 ThreadLocal 来解决
        // 将bii表状态改为支付方式
        int update = billDAO.update("update bill set state = ? where dinningTableId = ?", payWay, dinningTableId);
        if (update <= 0) {
            return false;
        }
        // 将餐桌状态置空
        if (!(dinningTableService.updateDinningTableToFree(dinningTableId))) {
            return false;
        }
        return true;
    }


}
