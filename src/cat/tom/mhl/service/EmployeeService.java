package cat.tom.mhl.service;

import cat.tom.mhl.dao.EmployeeDAO;
import cat.tom.mhl.domain.Employee;
import sun.plugin2.message.RemoteCAContextIdMessage;

import javax.swing.*;
import java.util.List;

/**
 * @author shkstart
 * @create 2023-10-09 19:54
 */
public class EmployeeService {

    EmployeeDAO employeeDAO = new EmployeeDAO();

    // 根据 empId 和 pwd 返回一个 Employee 对象
//    public Employee getEmployeeByIdAndPwd(String empId, String pwd){
//        return employeeDAO.querySingle("select * from employee where empId = ? and pwd = md5(?)", Employee.class, empId, pwd);
//    }

    // 获得所有员工信息
    public List<Employee> list(){
        return employeeDAO.queryMulti("SELECT * from employee", Employee.class);
    }

    // 添加员工 校验员工号
    public boolean addEmp(String empId, String name, String job){
        try {
            int update = employeeDAO.update("INSERT into employee values(null, ?, ?, ?)", empId, name, job);
            return update > 0;
        } catch (Exception e){
            System.out.println("请检查员工号是否唯一");
        }
        return false;
    }

    // 根据员工号删除员工
    public boolean delEmp(String empId){
        int update = employeeDAO.update("DELETE from employee where empId = ?", empId);
        return update > 0;
    }

    // 修改员工信息
    public boolean updateEmp(String empId, String name, String job){
        int update = employeeDAO.update("update employee set `name` = ?, job = ? where empId = ?", name, job, empId);
        return update > 0;
    }

}
