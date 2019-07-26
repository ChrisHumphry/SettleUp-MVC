package main.training.connections;

import java.sql.*;

public class GetConnection {

    static Connection connection;
    public ResultSet rs;
    public PreparedStatement ps;

    public static Connection getMysqlConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver"); //should be loadedc only once, the code would be in a static block
            connection = DriverManager.getConnection("jdbc:mysql://localhost/settleup", "root", "mysql");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getOracleConnection() {
        return null;
    }

}
