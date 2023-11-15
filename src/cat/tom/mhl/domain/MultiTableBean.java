package cat.tom.mhl.domain;

import java.util.Date;

/**
 * @author shkstart
 * @create 2023-10-23 10:39
 */
public class MultiTableBean {

    private Integer id;
    private String billId;
    private String menuId;
    private Integer nums;
    private Double money;
    private Integer dinningTableId;
    private Date billDate;
    private String state;
    private String foodName;    // 属性名与数据库字段名不一致，需要 修改 sql 语句，将字段名 as foodName


    public MultiTableBean() {
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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
                "\t\t\t" + state +
                "\t\t\t\t" + foodName;
    }
}
