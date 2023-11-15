package cat.tom.mhl.service;

import cat.tom.mhl.dao.MultiTableDAO;
import cat.tom.mhl.domain.MultiTableBean;

import java.util.List;

/**
 * @author shkstart
 * @create 2023-10-23 10:44
 */
public class MultiTableService {

    MultiTableDAO multiTableDAO = new MultiTableDAO();

    // 返回所有账单信息并带有菜品名
    public List<MultiTableBean> multiTableBeanList(){
        return multiTableDAO.queryMulti("select bill.*, `name` as foodName from bill, menu where bill.menuId = menu.id",
                MultiTableBean.class);
    }

}
