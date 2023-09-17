package vn.edu.iuh.fit.week01.Database;

import vn.edu.iuh.fit.week01.entities.Account;
import vn.edu.iuh.fit.week01.repositories.AccountRepository;

import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String username = "Tran Thi Met";
        String password = "123";

        AccountRepository AccRepo = new AccountRepository();
        Account account = new Account();
        account= AccRepo.login(username, password);
        if (account == null) {
            System.out.println("wrong password or username !!");
        } else {
            System.out.println("Ket noi thanh cong");
            System.out.println(account);


        }
    }
}
