package ch06.withoutrule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch06.UserDao;

/**
 * リスト6.8 複雑な共通処理が記述されたテストクラス
 * @author shuji.w6e
 */
@SuppressWarnings("unused")
public class UserDaoTest {
    private UserDao sut;
    private InMemoryDB db;

    @Before
    public void setUp() throws Exception {
        db = new InMemoryDB();
        db.start();
        sut = new UserDao();
    }

    @After
    public void tearDown() throws Exception {
        db.shutdownNow();
    }

    @Test
    public void getListは0件を返す() throws Exception {
        // 省略 
    }

}