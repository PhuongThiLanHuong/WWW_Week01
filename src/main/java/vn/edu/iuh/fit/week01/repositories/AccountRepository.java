package vn.edu.iuh.fit.week01.repositories;


import jakarta.servlet.http.HttpSession;
import org.checkerframework.checker.units.qual.A;
import vn.edu.iuh.fit.week01.Database.ConnectDatabse;
import vn.edu.iuh.fit.week01.entities.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository {
    private Connection connection;
    public AccountRepository() throws SQLException,ClassNotFoundException{
        this.connection= ConnectDatabse.getInstance().getConnection();
    }
    public boolean createAccount(Account account)
    {
        try{
            PreparedStatement statement=connection.prepareStatement("INSERT INTO account values (?,?,?,?,?,?) ");
            statement.setString(1,account.getAccount_id());
            statement.setString(2,account.getFull_name());
            statement.setString(3,account.getPassword());
            statement.setString(4, account.getEmail());
            statement.setString(5, account.getPhone());
            statement.setInt(6,1);
            int rowInserted=statement.executeUpdate();
        }catch(SQLException e)
        {
            throw  new RuntimeException(e);
        }
        return true;
    }
    public boolean deleteAccount(String id)
    {
        String sql="DELETE FROM account where account_id=?";
        try{
            PreparedStatement statement=this.connection.prepareStatement(sql);
            statement.setString(1,id);
            statement.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }
    public boolean updateAccount(Account account)
    {
        String sql="UPDATE account set full_name=?,password=?,email=?,phone=? where account_id=?";
        try{
            PreparedStatement statement=this.connection.prepareStatement(sql);
            statement.setString(1,account.getFull_name());
            statement.setString(2,account.getPassword());
            statement.setString(3, account.getEmail());
            statement.setString(4, account.getPhone());
            statement.setString(5, account.getAccount_id());
            statement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }
    public Optional<Account> getById(String id)
    {
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
    public List<Account> getAll()
    {
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
    public Account logIn(String username,String pass) throws SQLException {
        Account account= null;
        String sql="select*from account where full_name=?,password=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        try{
            statement.setString(1,username);
            statement.setString(2,pass);

            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next())
            {
                String account_id=resultSet.getString("account_id");
                String full_name=resultSet.getString("full_name");
                String password=resultSet.getString("password");
                String email=resultSet.getString("email");
                String phone=resultSet.getString("phone");
                Integer status=resultSet.getInt("status");
                account=new Account(account_id,full_name,password,email,phone,status);

            }
            resultSet.close();
            statement.close();
        }catch(SQLException E)
        {
            E.printStackTrace();
        }
        return account;
    }



}
