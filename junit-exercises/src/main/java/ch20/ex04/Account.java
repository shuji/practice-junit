package ch20.ex04;

public class Account {
    
    private String name;
    private String password;
    // Getter/Setter等は省略
    public Account() {
    }
    
    Account(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
