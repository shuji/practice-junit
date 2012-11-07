package ch03;

@SuppressWarnings("unused")
public class UserForm {

    private final String userName;
    private final String password;

    public UserForm(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean isValid() {
        return true;
    }

    public String getErrorMessage() {
        return "ユーザIDは必須項目です。";
    }
}
