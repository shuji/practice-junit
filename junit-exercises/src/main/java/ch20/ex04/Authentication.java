package ch20.ex04;

/**
 * リスト20.8 認証クラス
 * @author shuji.w6e
 */
public class Authentication {

    AccountDao dao = null;

    public Account authenticate(String userId, String password) {
        assert dao != null;
        Account account = dao.findOrNull(userId);
        if (account == null) return null;
        return account.getPassword().equals(password) ? account : null;
    }
}
