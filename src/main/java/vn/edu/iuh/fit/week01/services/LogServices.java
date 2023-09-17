package vn.edu.iuh.fit.week01.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week01.entities.Log;
import vn.edu.iuh.fit.week01.repositories.LogRepository;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LogServices {
    @Inject
    private LogRepository logRepository;
    public boolean create(Log log) throws SQLException, ClassNotFoundException {
        return logRepository.createLog(log);
    }
    public boolean detele(String id) throws SQLException, ClassNotFoundException {
        return logRepository.deleteLog(id);
    }
    public boolean update(Log log) throws SQLException, ClassNotFoundException {
        return logRepository.updateLog(log);
    }
    public Optional<Log> getById(String id) throws SQLException, ClassNotFoundException {
        return logRepository.getById(id);
    }
    public List<Log> getAll() throws SQLException, ClassNotFoundException {
        return logRepository.getAll();
    }

}
