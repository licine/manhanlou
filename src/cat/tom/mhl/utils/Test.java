package cat.tom.mhl.utils;

import javax.xml.transform.Source;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2023-10-07 8:54
 */
public class Test {

    private String name;
    public Test(String name){
        name = name;
    }
    public static void main(String[] args) throws SQLException {
        char[] charArray = {1,2,1,2,2,1,2,1};
        if(charArray[0] == charArray[1] && charArray[2] == charArray[5]){
            System.out.println(charArray.toString());
        }
//        Utility utility = new Utility();
//        char c = utility.readMenuSelection();
//        System.out.println(c);


//        Connection connection = JDBCUtilsByDruid.getConnection();
//        System.out.println(connection);
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from Employee");
//        while (resultSet.next()) {
//            System.out.println(resultSet.next());
//        }
//    }



        }
}
