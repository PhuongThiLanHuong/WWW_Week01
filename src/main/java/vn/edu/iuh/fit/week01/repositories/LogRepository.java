package vn.edu.iuh.fit.week01.repositories;


import vn.edu.iuh.fit.week01.Database.ConnectDatabse;
import vn.edu.iuh.fit.week01.entities.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LogRepository {
    public boolean createLog(Log log) throws SQLException, ClassNotFoundException {
        Connection connection= ConnectDatabse.getInstance().getConnection();
        try{
            PreparedStatement statement=connection.prepareStatement("INSERT INTO log values (?,?,?,?,?) ");
            statement.setString(1, log.getId());
            statement.setString(2,log.getAccount_id());
            statement.setDate(3,log.getLogin_time());
            statement.setDate(4, log.getLogout_time());
            statement.setString(5,log.getNotes());
            statement.executeUpdate();
            return true;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteLog(String id) throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        String sql="DELETE FROM log where id=?";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,id);
            statement.executeUpdate();
            return true;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateLog(Log log) throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        String sql="UPDATE log set account_id=?,login_time=?,logout_time=?,notes=? where id=?";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,log.getAccount_id());
            statement.setDate(2,log.getLogin_time());
            statement.setDate(3, log.getLogout_time());
            statement.setString(4, log.getNotes());
            statement.setString(5, log.getId());
            statement.executeUpdate();
            return true;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public Optional<Log> getById(String id) throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement("Select*from log where id=?");
            statement.setString(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next())
            {
               Log log=new Log(resultSet.getString(1),resultSet.getString(2), resultSet.getDate(3), resultSet.getDate(4), resultSet.getString(5));
                return  Optional.of(log);
            }

        }catch(Exception e)
        {
            throw  new RuntimeException(e);
        }
        return Optional.empty();
    }
    public List<Log> getAll() throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        PreparedStatement statement=null;
        List<Log>list=new ArrayList<>();
        try{
            statement=connection.prepareStatement("SELECT *FROM log");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
               Log log=new Log(resultSet.getString(0),resultSet.getString(1), resultSet.getDate(2), resultSet.getDate(3), resultSet.getString(4));
                list.add(log);
            }
        }catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        return list;
    }
}
