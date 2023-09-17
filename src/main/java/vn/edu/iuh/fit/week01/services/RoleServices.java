package vn.edu.iuh.fit.week01.services;

import jakarta.inject.Inject;

import vn.edu.iuh.fit.week01.entities.Role;
import vn.edu.iuh.fit.week01.repositories.RoleReponsitory;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RoleServices {
    @Inject
    private RoleReponsitory roleReponsitory;
    public boolean create(Role role) throws SQLException, ClassNotFoundException {
        return roleReponsitory.createRole(role);
    }
    public boolean detele(String id) throws SQLException, ClassNotFoundException {
        return roleReponsitory.deleteRole(id);
    }
    public boolean update(Role role) throws SQLException, ClassNotFoundException {
        return roleReponsitory.updateRole(role);
    }
    public Optional<Role> getById(String id) throws SQLException, ClassNotFoundException {
        return roleReponsitory.getById(id);
    }
    public List<Role> getAll() throws SQLException, ClassNotFoundException {
        return roleReponsitory.getAll();
    }
}
