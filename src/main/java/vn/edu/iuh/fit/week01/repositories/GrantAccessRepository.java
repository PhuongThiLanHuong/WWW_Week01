package vn.edu.iuh.fit.week01.repositories;

import vn.edu.iuh.fit.week01.Database.ConnectDatabse;
import vn.edu.iuh.fit.week01.entities.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GrantAccessRepository {
    public GrantAccessRepository() throws SQLException, ClassNotFoundException {
        Connection connection= ConnectDatabse.getInstance().getConnection();
    }
    public Role getRoleById(String id) throws SQLException, ClassNotFoundException {
        Connection connection=ConnectDatabse.getInstance().getConnection();
        Role role=null;
        try{
            String sql="";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,id);
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                role=new Role(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return role;
    }

}
