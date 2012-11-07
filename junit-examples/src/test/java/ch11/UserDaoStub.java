package ch11;

/**
 * リスト11.18 UserDaoの例外を送出するスタブ
 * @author shuji.w6e
 */
public class UserDaoStub implements UserDao {

    @Override
    public User find(String userId) throws UserNotFoundException {
        throw new UserNotFoundException("connection error");
    }

}
