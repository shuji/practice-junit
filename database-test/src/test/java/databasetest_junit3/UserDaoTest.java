package databasetest_junit3;

import static org.dbunit.PropertiesBasedJdbcDatabaseTester.*;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.h2.tools.Server;
import org.h2.util.JdbcUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class UserDaoTest extends DBTestCase {
    
    static String BASE_DIR = "h2";
    static String DB_NAME = "db";
    static String SCHEMA_NAME = "ut";
    static Server SERVER;
    @BeforeClass
    static public void setUpClass() throws Exception {
        // DBサーバの起動
        SERVER = Server.createTcpServer("-baseDir", BASE_DIR);
        SERVER.start();
        // スキーマの設定
        Properties props = new Properties();
        props.setProperty("user", "sa");
        props.setProperty("password", "");
        String url = "jdbc:h2:" + SERVER.getURL() + "/" + DB_NAME;
        Connection conn = org.h2.Driver.load().connect(url, props);
        try {
            conn.createStatement().execute("CREATE SCHEMA IF NOT EXISTS " + SCHEMA_NAME);
        } finally {
            JdbcUtils.closeSilently(conn);
        }
    }
    
    @AfterClass
    static public void tearDownClass() throws Exception {
        // DBサーバの停止
        SERVER.shutdown();
    }

    public UserDaoTest(String name) {
        super(name);
        System.setProperty(DBUNIT_DRIVER_CLASS, "org.h2.Driver");
        System.setProperty(DBUNIT_CONNECTION_URL, "jdbc:h2:tcp://localhost/db;SCHEMA=ut");
        System.setProperty(DBUNIT_USERNAME, "sa");
        System.setProperty(DBUNIT_PASSWORD, "");
        System.setProperty(DBUNIT_SCHEMA, "ut");
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(getClass().getResourceAsStream("fixtures.xml"));
    }

    public void testアサーション例() throws Exception {
        // 期待されるusersテーブルのデータセット
        InputStream expectedIn = getClass().getResourceAsStream("expected.xml");
        ITable expected = new FlatXmlDataSetBuilder().build(expectedIn).getTable("users");
        // 実データベースが保持するusersテーブルのデータセット
        ITable actual = super.getConnection().createDataSet().getTable("users");
        // アサーション
        org.dbunit.Assertion.assertEquals(expected, actual);
    }
    

}
