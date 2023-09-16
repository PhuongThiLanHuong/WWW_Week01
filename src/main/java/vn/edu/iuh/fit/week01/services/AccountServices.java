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
    public void create(Account account)
    {
        accountRepository.createAccount(account);
    }
    public void detele(String id)
    {
        accountRepository.deleteAccount(id);
    }
    public void update(Account account)
    {
        accountRepository.updateAccount(account);
    }
    public Optional<Account> getById(String id)
    {
        return accountRepository.getById(id);
    }
    public List<Account> getAll(){
        return accountRepository.getAll();
    }
    public Account logIn(String username,String password) throws SQLException {
        return accountRepository.logIn(username,password);
    }
}
