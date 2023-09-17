package vn.edu.iuh.fit.week01.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week01.entities.Account;
import vn.edu.iuh.fit.week01.repositories.AccountRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AccountServices {
    @Inject
    private AccountRepository accountRepository;
    public boolean create(Account account) throws SQLException, ClassNotFoundException {
        return accountRepository.createAccount(account);
    }
    public boolean detele(String id) throws SQLException, ClassNotFoundException {
        return accountRepository.deleteAccount(id);
    }
    public boolean update(Account account) throws SQLException, ClassNotFoundException {
        return accountRepository.updateAccount(account);
    }
    public Optional<Account> getById(String id) throws SQLException, ClassNotFoundException {
        return accountRepository.getById(id);
    }
    public List<Account> getAll() throws SQLException, ClassNotFoundException {
        return accountRepository.getAll();
    }
    public Account logIn(String username,String password)  {
        return accountRepository.login(username,password);
    }
}
