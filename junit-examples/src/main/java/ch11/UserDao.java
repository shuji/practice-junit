package ch11;

/**
 * リスト11.17 ユーザ情報を取得するインタフェース
 * @author shuji.w6e
 */
public interface UserDao {

    User find(String userId) throws UserNotFoundException;
}
