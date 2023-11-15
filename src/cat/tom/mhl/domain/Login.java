package cat.tom.mhl.domain;

import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author shkstart
 * @create 2023-10-23 11:44
 */
public class Login {

    private Integer id;
    private String empId;
    private String pwd;

    public Login() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
