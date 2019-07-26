package training.dao;

import training.beans.User;
import training.connections.GetConnection;
import training.standards.IUserDAO;

import java.sql.SQLException;

public class UserDAO implements IUserDAO {
    @Override
    public boolean insertUser(User user) {

        String sql = "insert into users values (?,?)";
        GetConnection gc = new GetConnection();

        try {

            gc.ps = GetConnection.getMysqlConnection().prepareStatement(sql);
            gc.ps.setInt(1, user.getId());
            gc.ps.setString(2, user.getName());

            return gc.ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }
}
