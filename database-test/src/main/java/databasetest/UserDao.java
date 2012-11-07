package databasetest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * リスト12.2 ユーザテーブルにアクセスするためのDAOクラス
 * @author shuji.w6e
 */
public class UserDao {

    public List<String> getList() throws SQLException {
        ResultSet rs = createStatement().executeQuery("SELECT name FROM users");
        LinkedList<String> result = new LinkedList<String>();
        while (rs.next()) {
            result.add(rs.getString(1));
        }
        return result;
    }

    public void insert(String username) throws SQLException {
        String sql = "INSERT INTO users(name) VALUES('" + username + "')";
        createStatement().executeUpdate(sql);
    }

    private Statement createStatement() throws SQLException {
        String url = "jdbc:h2:tcp://localhost/db;SCHEMA=ut";
        Connection connection = DriverManager.getConnection(url, "sa", "");
        return connection.createStatement();
    }
}
