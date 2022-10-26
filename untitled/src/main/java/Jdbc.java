import java.beans.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
    private static final String URL = "jdbc:mysql://localhost:3306/pets";
    private static final String USER = "root";
    private static final String PWD = "Wx123450?!";
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void close(ResultSet rs,Statement state,Connection conn) {
        try {
            if(rs != null) {
                rs.close();
            }
            if(state != null) {
                ((Connection) state).close();
            }
            if(conn !=null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
