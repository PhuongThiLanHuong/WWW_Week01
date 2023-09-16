package vn.edu.iuh.fit.week01.entities;

public class Account {
    private String account_id;
    private String full_name;
    private String password;
    private String email;
    private String phone;
    private int status;

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account()
    {

    }
    public Account(String account_id,String full_name,String password,String email,String phone,int status)
    {
        this.account_id=account_id;
        this.full_name=full_name;
        this.password=password;
        this.email=email;
        this.phone=phone;
        this.status=status;

    }
    public Account(String account_id)
    {
        this.account_id=account_id;
    }
    @Override
    public String toString() {
        return "Account{" +
                "account_id='" + account_id + '\'' +
                ", full_name='" + full_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
