package ch06.rule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import ch06.UserDao;

/**
 * リスト6.9 ルールを使った共通処理の抽出
 * @author shuji.w6e
 */
@SuppressWarnings("unused")
public class UserDaoTest {
    private UserDao sut;
    @Rule
    public InMemoryDBRule db = new InMemoryDBRule();

    @Before
    public void setUp() throws Exception {
        sut = new UserDao();
    }

    @Test
    public void getListは0件を返す() throws Exception {
        // 省略 
    }
}