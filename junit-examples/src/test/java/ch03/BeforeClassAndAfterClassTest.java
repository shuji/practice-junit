package ch03;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * リスト3.15 BeforeClassアノテーションによる初期化処理
 * リスト3.16 AfterClassアノテーションによる後処理
 * @author shuji.w6e
 */
public class BeforeClassAndAfterClassTest {
    
    @BeforeClass
    public static void setUpClass() throws Exception {
      // JDBC Driverの読み込み
      Class.forName("com.mysql.jdbc.Driver");
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        GlobalResources.release();
    }

}
