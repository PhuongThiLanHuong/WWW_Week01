package vn.edu.iuh.fit.week01.repositories;



import vn.edu.iuh.fit.week01.Database.ConnectDatabse;
import vn.edu.iuh.fit.week01.entities.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository {
    public boolean createAccount(Account account) throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        try{
            PreparedStatement statement=connection.prepareStatement("INSERT INTO account values (?,?,?,?,?,?) ");
            statement.setString(1,account.getAccount_id());
            statement.setString(2,account.getFull_name());
            statement.setString(3,account.getPassword());
            statement.setString(4, account.getEmail());
            statement.setString(5, account.getPhone());
            statement.setInt(6,account.getStatus());
            statement.executeUpdate();
            return true;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteAccount(String id) throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        String sql="DELETE FROM account where account_id=?";
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
    public boolean updateAccount(Account account) throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        String sql="UPDATE account set full_name=?,password=?,email=?,phone=? where account_id=?";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,account.getFull_name());
            statement.setString(2,account.getPassword());
            statement.setString(3, account.getEmail());
            statement.setString(4, account.getPhone());
            statement.setString(5, account.getAccount_id());
            statement.executeUpdate();
            return true;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public Optional<Account> getById(String id) throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement("Select*from account where account_id=?");
            statement.setString(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next())
            {
                Account a=new Account(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
                return  Optional.of(a);
            }

        }catch(Exception e)
        {
            throw  new RuntimeException(e);
        }
        return Optional.empty();
    }
    public List<Account> getAll() throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        PreparedStatement statement=null;
        List<Account>list=new ArrayList<>();
        try{
            statement=connection.prepareStatement("SELECT *FROM account");
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                Account a=new Account(rs.getString(0),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                list.add(a);
            }
        }catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        return list;
    }
    public Account login(String name, String pass){
        Account a = null;
        try {
            Connection connection = ConnectDatabse.getInstance().getConnection();
            String sql = "select * from account where full_name=? and password=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                String id = rs.getString(1);
                String fullName = rs.getString(2);
                String passWord = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
               int status = rs.getInt(6);
                a = new Account(id, fullName, passWord, email, phone, status);
            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return a;

    }



}
