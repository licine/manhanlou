package cat.tom.mhl.view;

import cat.tom.mhl.domain.*;
import cat.tom.mhl.service.*;
import cat.tom.mhl.utils.Utility;
import com.alibaba.druid.sql.ast.statement.SQLWithSubqueryClause;

import java.io.OutputStream;
import java.util.List;

/**
 * @author shkstart
 * @create 2023-10-07 15:30
 */
public class MHLView {

    // 控制是否退出菜单
    private boolean loop = true;

    // 定义 EmployeeService 属性
    EmployeeService employeeService = new EmployeeService();

    // 定义 DinningTableService 属性
    DinningTableService dinningTableService = new DinningTableService();

    // 定义 MenuService 属性
    MenuService menuService = new MenuService();

    // 定义 BillService 属性
    BillService billService = new BillService();

    // 定义 MultiService 属性
    MultiTableService multiTableService = new MultiTableService();

    LoginService loginService = new LoginService();
    

    private String key = ""; // 接受用户选择

    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

    // 显示主菜单
    public void mainMenu(){
        while (loop){

            System.out.println("================================满汉楼============================");
            System.out.println();
            System.out.println("\t\t 1 登录满汉楼");
            System.out.println("\t\t 2 退出满汉楼");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);

            switch (key){
                case "1":
                    System.out.print("请输入员工号：");
                    String empId = Utility.readString(50);
                    System.out.print("请输入密 码：");
                    String pwd = Utility.readString(50);
                    // TODO: 2023/10/7 去数据库做校验 一会再做
                    if (loginService.getLoginByIdAndPwd(empId, pwd) != null){
                        System.out.println("================================登录成功============================");
                        System.out.println();
                        // 显示二级菜单
                        while (loop){

                            System.out.println("============================满汉楼二级菜单========================");
                            System.out.println();
                            System.out.println("\t\t 1 显示餐桌状态");
                            System.out.println("\t\t 2 预定餐桌");
                            System.out.println("\t\t 3 显示所有菜品");
                            System.out.println("\t\t 4 点餐服务");
                            System.out.println("\t\t 5 查看账单");
                            System.out.println("\t\t 6 结账");
                            System.out.println("\t\t 7 人事管理");
                            System.out.println("\t\t 9 退出满汉楼");
                            System.out.print("请输入你的选择：");
                            String key2 = Utility.readString(1);
                            switch (key2){
                                case "1":
                                    showDinningTablesStates();
                                    break;
                                case "2":
                                    orderDinningTable();
                                    break;
                                case "3":
                                    showMenu();
                                    break;
                                case "4":
                                    orderMenu();
                                    break;
                                case "5":
                                    listBill2();
//                                    listBill();
                                    break;
                                case "6":
                                    payBill();
                                    break;
                                case "7":
                                    personManage();
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("输入错误，请您重新输入");

                            }

                        }

                    } else {
                        System.out.println("\n================================登录失败============================");
                        System.out.println();
                    }
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.print("输入错误，请重新输入（1 或 2）：");
                    break;
            }

        }

        System.out.println("你退出满汉楼系统~");
    }


    // 人事管理
    public void personManage(){
        while (true){
            System.out.println("============================人事管理二级菜单========================");
            System.out.println();
            System.out.println("\t\t 1 查询员工信息");
            System.out.println("\t\t 2 添加员工");
            System.out.println("\t\t 3 删除员工");
            System.out.println("\t\t 4 修改员工信息");
            System.out.println("\t\t 5 退出");
            System.out.print("请输入你的选择：");
            String key = Utility.readString(1);
            switch (key){
                case "1":
                    System.out.println("\n============================所有员工信息========================");
                    for (Employee employee : employeeService.list()) {
                        System.out.println(employee);
                    }
                    System.out.println("\n============================显示结束========================");
                    break;
                case "2":
                    System.out.println("\n============================添加员工========================");
                    System.out.print("请输入员工号：");
                    String empId = Utility.readString(50);
                    System.out.print("请输入员工姓名：");
                    String name = Utility.readString(50);
                    System.out.print("请输入员工职位：");
                    String job = Utility.readString(50);
                    if (!(employeeService.addEmp(empId, name, job))) {
                        System.out.println("============================添加失败，请检查员工号是否正确且未重复========================");
                        continue;
                    }
                    System.out.println("\n============================添加成功========================");
                    break;
                case "3":
                    System.out.println("\n============================删除员工========================");
                    System.out.print("请输入员工号：");
                    String empId2 = Utility.readString(50);
                    if (!(employeeService.delEmp(empId2))) {
                        System.out.println("\n============================删除失败，请检查员工号是否输入正确========================");
                    }
                    System.out.println("\n============================删除成功========================");
                    break;

                case "4":
                    System.out.println("\n============================修改员工信息========================");
                    System.out.print("请输入要修改员工信息的员工号：");
                    String empId4 = Utility.readString(50);
                    System.out.print("请输入修改后的员工姓名：");
                    String name4 = Utility.readString(50);
                    System.out.print("请输入修改后的员工职位：");
                    String job4 = Utility.readString(50);
                    if (!(employeeService.updateEmp(empId4, name4, job4))) {
                        System.out.println("\n============================修改失败，请检查员工号是否输入正确========================");

                    }
                    System.out.println("\n============================修改成功========================");
                    break;
                case "5":
                    System.out.println("\n============================退出人事管理二级菜单========================");
                    return;

            }

        }
    }


    // 结账
    public void payBill(){


        System.out.println("\n============================结账服务========================");

        // 用户输入餐桌编号，-1退出
        System.out.print("请选择要结账的餐桌编号（-1退出）：");
        int tableNumber = Utility.readNumber();
        if (tableNumber == -1) {
            System.out.println("\n============================取消结账========================");
            return;
        }

        // 如果餐桌不存在则直接返回
        DinningTable table = dinningTableService.getDinningTableById(tableNumber);
        if (table == null){
            System.out.println("餐桌不存在，请重新输入");
            return;
        }

        // 如果用户输入的餐桌没有未结帐的账单，则直接返回
        if (!(billService.hasPayBillByDinningTableId(tableNumber))){
            System.out.println("该餐桌没有未结帐到账单，请重新输入");
            return;
        }

        // 输入支付方式，然后支付
        System.out.print("结账的方式(现金/微信/支付宝)：");
        String payWay = Utility.readString(3);
        System.out.print("确认是否结账（Y/N）：");
        char key = Utility.readConfirmSelection();
        if (key == 'N'){
            System.out.println("\n============================取消结账========================");
            return;
        }
        if (!(billService.payBill(tableNumber, payWay))){
            System.out.println("\n============================结账失败========================");
            return;
        }

        System.out.println("\n============================结账成功========================");

    }


    // 带有菜品名的账单明细
    public void listBill2(){

        System.out.println("============================账单明细如下========================\n");
        System.out.println("编号\t\t菜品号\t\t\t菜品量\t\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t\t状态\t\t\t\t菜品名");

        // 拿到所有bill对象，并遍历输出
        List<MultiTableBean> multiTableBeans = multiTableService.multiTableBeanList();
        for (MultiTableBean multiTableBean : multiTableBeans) {
            System.out.println(multiTableBean);
        }

        System.out.println("============================显示结束========================\n");
    }


    // 账单明细
    public void listBill(){

        System.out.println("============================账单明细如下========================\n");
        System.out.println("编号\t\t菜品号\t\t\t菜品量\t\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t\t状态");

        // 拿到所有bill对象，并遍历输出
        List<Bill> billList = billService.list();
        for (Bill bill : billList) {
            System.out.println(bill);
        }
        System.out.println("============================显示结束========================\n");
    }


    // 点餐
    // 小 bug -- 没预定也可以点餐，这样点餐之后没有点餐人姓名与电话
    public void orderMenu(){

        System.out.println("\n============================点餐服务========================");

        // 输入桌号，并验证是否存在
        System.out.print("请选择点餐的桌号（-1 退出）：");
        int tableNumber= Utility.readNumber();
        if (tableNumber == -1) {
            System.out.println("\n============================取消点餐========================");
            return;
        }
        DinningTable dinningTable = dinningTableService.getDinningTableById(tableNumber);
        if (dinningTable == null) {
            System.out.println("桌号不存在，请重新输入！");
            return;
        }

        // 输入菜品号，并验证是否存在
        System.out.print("请选择要菜品的编号（-1 退出）：");
        int orderMenuId= Utility.readNumber();
        if (orderMenuId == -1) {
            System.out.println("\n============================取消点餐========================");
            return;
        }
        Menu menu = menuService.getMenuById(orderMenuId);
        if (menu == null) {
            System.out.println("菜品号不存在，请重新输入！");
            return;
        }

        // 输入菜品数量
        System.out.print("请选择菜品数量（-1 退出）：");
        int nums = Utility.readNumber();
        if (nums == -1) {
            System.out.println("\n============================取消点餐========================");
            return;
        }

        // 再次确认是否点餐
        System.out.print("确认是否点这个菜（Y/N）：");
        char key = Utility.readConfirmSelection();
        if (key == 'Y'){    // 要点

            if (!(billService.orderMenu(orderMenuId, nums, tableNumber))){
                System.out.println("\n============================点餐失败========================");
                return;
            }

        }else {     // 不点了
            System.out.println("\n============================取消点餐========================");
            return;
        }

        System.out.println("\n============================点餐成功========================");

    }


//    显示所有菜品
    public void showMenu(){
        System.out.println("\n============================所有菜品========================");
        System.out.println("\n菜品编号\t\t菜品名称\t\t菜品类型\t\t菜品价格");
//        输出菜品信息
        for (Menu menu : menuService.listMenu()) {
            System.out.println(menu);
        }

        System.out.println("\n============================显示结束========================\n");    }


    // 预定餐桌
    public void orderDinningTable(){
        System.out.println("\n============================预定餐桌========================");
        System.out.print("请选择要预定餐桌的编号（-1 退出）：");
        int id = Utility.readNumber();
        if (id == -1) {
            System.out.println("\n============================取消预定餐桌========================\n");
            return;
        }
        System.out.print("确认是否预定（Y/N）：");

        // 该方法得到的是Y或N
        char key = Utility.readConfirmSelection();
        // 根据 orderId 返回对应 DinningTable 对象，如果为 null， 则说明对象不存在；
        DinningTable dinningTable = dinningTableService.getDinningTableById(id);
        if (key == 'Y'){    // 要预定
            // 餐桌不存在
            if (dinningTable == null){
                System.out.println("餐桌不存在，请重新预定！");
                return;
            }

//            餐桌状态不为空
            if (!("空".equals(dinningTable.getState()))){
                System.out.println("餐桌已预订或正在就餐中，请重新预定其他餐桌。");
                return;
            }

//            开始真正预定餐桌
            System.out.print("预订人姓名：");
            String orderName = Utility.readString(50);
            System.out.print("预订人电话：");
            String orderTel = Utility.readString(50);
            if (dinningTableService.orderDinningTable(id, orderName, orderTel)){
                System.out.println("\n============================预定成功！========================\n");
            } else {
                System.out.println("\n============================预定失败！========================\n");
            }

        } else {
            System.out.println("\n============================取消预定餐桌========================\n");
        }
    }


    //    显示餐桌状态
    public void showDinningTablesStates(){
        System.out.println("\n============================餐桌状态========================");
        System.out.println("\n餐桌编号\t\t餐桌状态");
        List<DinningTable> dinningTables = dinningTableService.list();
        for (DinningTable dinningTable : dinningTables) {
            System.out.println(dinningTable);
        }
        System.out.println("\n============================显示结束========================\n");
    }
}

