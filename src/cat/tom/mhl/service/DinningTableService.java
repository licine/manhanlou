package cat.tom.mhl.service;

import cat.tom.mhl.dao.DinningTableDAO;
import cat.tom.mhl.domain.DinningTable;

import java.util.List;

/**
 * @author shkstart
 * @create 2023-10-10 21:52
 */
public class DinningTableService {

    DinningTableDAO dinningTableDAO = new DinningTableDAO();

    // 返回所有餐桌的所有信息
    public List<DinningTable> list(){
        return dinningTableDAO.queryMulti("select * from dinningTable", DinningTable.class);
    }

    // 根据Id查询对应的DinningTable对象；
    // 如果返回 null 则表示预定的餐桌不存在
    public DinningTable getDinningTableById(int id){
        return dinningTableDAO.querySingle("select * from dinningTable where id = ?", DinningTable.class, id);
    }


    // 将预定信息写入数据库，包括预订人姓名、手机号
    public boolean orderDinningTable(int id, String orderName, String orderTel){
        int update =
                    dinningTableDAO.update("update dinningTable set state = '已预定', orderName = ?, orderTel = ? where id = ?", orderName, orderTel, id);
        return update > 0;
    }

    // 根据 id 修改对应餐桌就餐状态
    public boolean updateDinningTableState(String state, int id){
        int update = dinningTableDAO.update("update dinningTable set state = ? where id = ?", state, id);
        return update > 0;
    }

    // 将餐桌状态置空
    public boolean updateDinningTableToFree(int dinningTableId){
        int update = dinningTableDAO.update("update dinningTable set state = '空' where id = ?", dinningTableId);
        return update > 0;
    }

}
