package vn.edu.iuh.fit.week01.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week01.entities.Account;
import vn.edu.iuh.fit.week01.entities.Log;
import vn.edu.iuh.fit.week01.repositories.AccountRepository;
import vn.edu.iuh.fit.week01.repositories.LogRepository;

import java.util.List;
import java.util.Optional;

public class LogServices {
    @Inject
    private LogRepository logRepository;
    public void Create(Log log)
    {
        logRepository.create(log);
    }
    public Optional<Log> getById(String id)
    {
        return logRepository.getById(id);
    }
    public List<Log> getAll(){
        return logRepository.getAll();
    }

}
