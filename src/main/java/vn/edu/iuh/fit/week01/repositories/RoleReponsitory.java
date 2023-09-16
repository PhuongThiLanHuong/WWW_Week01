package vn.edu.iuh.fit.week01.repositories;

import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.week01.entities.Account;
import vn.edu.iuh.fit.week01.entities.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleReponsitory {
    private Connection connection;
    private HttpSession session;
    public RoleReponsitory(HttpSession session) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String c = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
        connection = DriverManager.getConnection(c,"root","123456");
        this.session = session;
    }
    public void create(Role role)
    {
        try{
            PreparedStatement statement=connection.prepareStatement("INSERT INTO role values (?,?,?,?) ");
            statement.setString(1, role.getRole_id());
            statement.setString(2, role.getRole_name());
            statement.setString(3, role.getDescription());
            statement.setInt(4, role.getStatus());

            int rowInserted=statement.executeUpdate();
        }catch(SQLException e)
        {
            throw  new RuntimeException(e);
        }
    }
    public Optional<Role> getById(String id)
    {
        PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement("Select*from role where role_id=?");
            statement.setString(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next())
            {
                Role role=new Role(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                return  Optional.of(role);
            }

        }catch(Exception e)
        {
            throw  new RuntimeException(e);
        }
        return Optional.empty();
    }
    public List<Role> getAll()
    {
        PreparedStatement statement=null;
        List<Role>list=new ArrayList<>();
        try{
            statement=connection.prepareStatement("SELECT *FROM role");
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                Role role=new Role(rs.getString(0),rs.getString(1),rs.getString(2),rs.getInt(3));
                list.add(role);
            }
        }catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        return list;
    }
}
