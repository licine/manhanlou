package cat.tom.mhl.domain;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author shkstart
 * @create 2023-10-21 9:39
 * javabean
 *  id int primary key auto_increament comment '主键自增',
 * 	billId varchar(50) unique not null default '账单编号 可以按照自己的规则生成UUID',
 * 	menuId int not null default 0 comment '菜品编号',
 * 	nums int not null default 0 comment '份数',
 * 	money double not null default 0 comment '金额',
 * 	dinningTableId int not null default 0 comment '餐桌编号',
 * 	billDate DATETIME not null comment '订单日期',
 * 	state varchar(50) not null default '' comment '状态 未结帐 已结账 挂单',
 */
public class Bill {

    private Integer id;
    private String billId;
    private String menuId;
    private Integer nums;
    private Double money;
    private Integer dinningTableId;
    private Date billDate;
    private String state;


    public Bill() {
    }

    public Bill(Integer id, String billId, String menuId, Integer nums, Double money, Integer dinningTableId, Date billDate, String state) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.dinningTableId = dinningTableId;
        this.billDate = billDate;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDinningTableId() {
        return dinningTableId;
    }

    public void setDinningTableId(Integer dinningTableId) {
        this.dinningTableId = dinningTableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id + "\t\t" + menuId +
                "\t\t\t\t" + nums +
                "\t\t\t\t" + money +
                "\t" + dinningTableId +
                "\t\t" + billDate +
                "\t\t\t" + state;
    }
}
