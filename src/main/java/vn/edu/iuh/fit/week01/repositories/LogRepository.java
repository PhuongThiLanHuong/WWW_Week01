package vn.edu.iuh.fit.week01.repositories;

import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.week01.entities.Account;
import vn.edu.iuh.fit.week01.entities.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LogRepository {
    private Connection connection;
    private HttpSession session;

    public LogRepository(HttpSession session) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String c = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
        connection = DriverManager.getConnection(c,"root","123456");
        this.session = session;
    }
    public void create(Log log)
    {
        try{
            PreparedStatement statement=connection.prepareStatement("INSERT INTO log values (?,?,?,?,?,? ");
            statement.setString(1,log.getId());
            statement.setString(2,log.getAccount_id());
            statement.setDate(3,log.getLogin_time());
            statement.setDate(3,log.getLogout_time());
            statement.setString(5, log.getNotes());
            int rowInserted=statement.executeUpdate();
        }catch(SQLException e)
        {
            throw  new RuntimeException(e);
        }
    }
    public Optional<Log> getById(String id)
    {
        PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement("Select*from log where id=?");
            statement.setString(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next())
            {
                Log log=new Log(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getDate(4), resultSet.getString(5));
                return  Optional.of(log);
            }

        }catch(Exception e)
        {
            throw  new RuntimeException(e);
        }
        return Optional.empty();
    }
    public List<Log> getAll()
    {
        PreparedStatement statement=null;
        List<Log>list=new ArrayList<>();
        try{
            statement=connection.prepareStatement("SELECT *FROM log");
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                Log log=new Log(rs.getString(0),rs.getString(1),rs.getDate(2),rs.getDate(3),rs.getString(4));
                list.add(log);
            }
        }catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        return list;
    }
}
