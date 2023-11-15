package cat.tom.mhl.service;

import cat.tom.mhl.dao.LoginDAO;
import cat.tom.mhl.domain.Login;

/**
 * @author shkstart
 * @create 2023-10-23 11:46
 */
public class LoginService {

    LoginDAO loginDAO = new LoginDAO();

    // 根据员工号和密码返回登录对象
    public Login getLoginByIdAndPwd(String empId, String pwd){
        return loginDAO.querySingle("select * from login where empid = ? and pwd = md5(?)", Login.class, empId, pwd);
    }
}
