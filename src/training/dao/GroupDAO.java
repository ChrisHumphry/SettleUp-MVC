package training.dao;

import training.beans.Group;
import training.connections.GetConnection;
import training.standards.IGroupDAO;

import java.sql.SQLException;

public class GroupDAO implements IGroupDAO {
    @Override
    public boolean insertGroup(Group group) {
        String sql = "insert into groups values (?,?)";
        GetConnection gc = new GetConnection();

        try {

            gc.ps = GetConnection.getMysqlConnection().prepareStatement(sql);
            gc.ps.setInt(1, 1);
            gc.ps.setString(2, group.getName());

            return gc.ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
