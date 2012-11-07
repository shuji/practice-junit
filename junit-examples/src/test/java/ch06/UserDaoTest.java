package ch06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * リスト6.4 UserDaoクラスのテストクラス
 * @author shuji.w6e
 */
@RunWith(Enclosed.class)
public class UserDaoTest {

    public static class テーブルが空の場合 {
        UserDao sut;

        @Before
        public void setUp() throws Exception {
            DbUtils.drop("users");
            sut = new UserDao();
        }

        @Ignore("未実装")
        @Test
        public void getListで0件取得できる() throws Exception {
            List<User> actual = sut.getList();
            assertThat(actual, is(notNullValue()));
            assertThat(actual.size(), is(0));
        }
    }

    public static class テーブルにサンプルデータが100件含まれる場合 {
        UserDao sut;

        @Before
        public void setUp() throws Exception {
            DbUtils.drop("users");
            DbUtils.insert("users", getClass().getResource("users.yaml"));
            sut = new UserDao();
        }

        @Ignore("未実装")
        @Test
        public void getListで100件取得できる() throws Exception {
            List<User> actual = sut.getList();
            assertThat(actual, is(notNullValue()));
            assertThat(actual.size(), is(100));
        }
    }

}
