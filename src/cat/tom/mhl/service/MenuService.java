package cat.tom.mhl.service;

import cat.tom.mhl.dao.MenuDAO;
import cat.tom.mhl.domain.Menu;

import java.util.List;

/**
 * @author shkstart
 * @create 2023-10-15 10:21
 */
public class MenuService {

    MenuDAO menuDAO = new MenuDAO();

    // 获取 menu 表所有信息
    public List<Menu> listMenu(){
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }

    // 根据 ID 获得 menu 对象
    public Menu getMenuById(int id){
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
    }
}
