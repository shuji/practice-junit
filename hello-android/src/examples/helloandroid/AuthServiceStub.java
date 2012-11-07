package examples.helloandroid;

/**
 * リスト13.5 ユーザ認証のスタブ実装
 * @author shuji.w6e
 */
public class AuthServiceStub implements AuthService {
    @Override
    public boolean login(AuthUser authUser) {
        return (authUser.userId.equals("duke") && authUser.password.equals("3micro"));
    }
}
