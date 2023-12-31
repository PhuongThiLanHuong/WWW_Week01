package vn.edu.iuh.fit.week01.repositories;

import vn.edu.iuh.fit.week01.Database.ConnectDatabse;
import vn.edu.iuh.fit.week01.entities.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleReponsitory {
    public boolean createRole(Role role) throws SQLException, ClassNotFoundException {
        Connection connection= ConnectDatabse.getInstance().getConnection();
        try{
            PreparedStatement statement=connection.prepareStatement("INSERT INTO role values (?,?,?,?) ");
            statement.setString(1, role.getRole_id());
            statement.setString(2, role.getRole_name());
            statement.setString(3, role.getDescription());
            statement.setInt(4,role.getStatus());
            statement.executeUpdate();
            return true;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteRole(String id) throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        String sql="DELETE FROM role where role_id=?";
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
    public boolean updateRole(Role role) throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        String sql="UPDATE role set role_name=?,description=?,status=? where role_id=?";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,role.getRole_name());
            statement.setString(2, role.getDescription());
            statement.setInt(3,role.getStatus());
            statement.setString(4, role.getRole_id());
            statement.executeUpdate();
            return true;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public Optional<Role> getById(String id) throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        PreparedStatement statement=null;
        try{
            statement=connection.prepareStatement("Select*from role where role_id=?");
            statement.setString(1,id);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next())
            {
               Role role=new Role(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
                return  Optional.of(role);
            }

        }catch(Exception e)
        {
            throw  new RuntimeException(e);
        }
        return Optional.empty();
    }
    public List<Role> getAll() throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        PreparedStatement statement=null;
        List<Role>list=new ArrayList<>();
        try{
            statement=connection.prepareStatement("SELECT *FROM role");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Role role=new Role(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
                list.add(role);
            }
        }catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        return list;
    }
    public List<Role> getRolesForAccount(String account_id) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Role> listRole = new ArrayList<>();
        try {
            connection = ConnectDatabse.getInstance().getConnection();
            String sql = "SELECT role.* " +
                    "FROM role " +
                    "INNER JOIN grant_access ON role.role_id = grant_access.role_id " +
                    "WHERE grant_access.account_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, account_id);
            rs = ps.executeQuery();
            while(rs.next()){
                String role_id1 = rs.getString("role_id");
                String role_name = rs.getString("role_name");
                String description = rs.getString("description");
                Short status = rs.getShort("status");

                Role role = new Role(role_id1, role_name, description,status);
                listRole.add(role);
            }
            return listRole;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
