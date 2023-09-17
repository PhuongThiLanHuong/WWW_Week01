package vn.edu.iuh.fit.week01.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb","root","123456");
            statement=connection.createStatement();
            String sql="select *from mydb.account";
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next())
            {
                String fullname=resultSet.getString(2);
                String pass=resultSet.getString(3);
                System.out.println(fullname);
                System.out.println(pass);
                System.out.println("Connected");

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
