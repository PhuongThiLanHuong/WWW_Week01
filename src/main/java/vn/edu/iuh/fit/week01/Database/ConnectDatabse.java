package vn.edu.iuh.fit.week01.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabse {
    private static ConnectDatabse instance=null;
    private Connection connection;
    public ConnectDatabse() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        String url = "jdbc:mariadb://localhost:3306/mydb?";
        connection = DriverManager.getConnection(url, "root", "123456");
    }

    public Connection getConnection()
    {
        return  connection;
    }
    public static ConnectDatabse getInstance() throws SQLException,ClassNotFoundException{
        if(instance==null)
            instance=new ConnectDatabse();
        return  instance;
    }

}
