package cat.tom.mhl.domain;

/**
 * @author shkstart
 * @create 2023-10-09 12:20
 * 这是一个 javabean 与 Employee 对应
 * 	id INT PRIMARY KEY AUTO_INCREMENT,	# 自增
 * 	empId VARCHAR(50) UNIQUE NOT NULL DEFAULT '',	# 员工号
 * 	pwd char(32) NOT NULL DEFAULT '',	# 密码md5
 * 	`name` VARCHAR(50) NOT NULL DEFAULT '',	# 姓名
 * 	job VARCHAR(50) NOT NULL DEFAULT ''	# 岗位
 */

public class Employee {

    private Integer id;
    private String empId;
//    private String pwd;
    private String name;
    private String job;

    public Employee() {     // 无参构造器，底层 apache-dbutils 需要
    }

    public Employee(int id, String empId, String name, String job) {
        this.id = id;
        this.empId = empId;
//        this.pwd = pwd;
        this.name = name;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

//    public String getPwd() {
//        return pwd;
//    }
//
//    public void setPwd(String pwd) {
//        this.pwd = pwd;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return  id + "\t\t\t" + empId +
                "\t\t\t" + name +
                "\t\t\t" + job;
    }
}
