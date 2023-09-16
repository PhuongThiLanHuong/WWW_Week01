package vn.edu.iuh.fit.week01.services;

import vn.edu.iuh.fit.week01.entities.Log;
import vn.edu.iuh.fit.week01.entities.Role;
import vn.edu.iuh.fit.week01.repositories.LogRepository;
import vn.edu.iuh.fit.week01.repositories.RoleReponsitory;

import java.util.List;
import java.util.Optional;

public class RoleServices {
    private RoleReponsitory roleRepository;
    public void Create(Role role)
    {
        roleRepository.create(role);
    }
    public Optional<Role> getById(String id)
    {
        return roleRepository.getById(id);
    }
    public List<Role> getAll(){
        return roleRepository.getAll();
    }
}
