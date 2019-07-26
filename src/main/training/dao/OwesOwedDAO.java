package main.training.dao;

import main.training.beans.Group;
import main.training.beans.User;
import main.training.standards.IOwesOwedDAO;
import main.training.connections.GetConnection;

import java.sql.SQLException;

public class OwesOwedDAO implements IOwesOwedDAO {
    @Override
    public boolean insertOwesOwed(User user, Group group, int owes, int owed) {
        String sql = "insert into owesowed values (?,?,?,?)";
        GetConnection gc = new GetConnection();

        try {

            gc.ps = GetConnection.getMysqlConnection().prepareStatement(sql);
            gc.ps.setInt(1, user.getId());
            gc.ps.setInt(2, group.getId());
            gc.ps.setInt(3, owes);
            gc.ps.setInt(4, owed);

            return gc.ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public int[] getOwesOwed(User user, Group group) {

        String sql = "select owes, owed from owesowed where user_id=? and group_id=? ";
        GetConnection gc=new GetConnection();

        int[] bal = new int[2];
        try {
            gc.ps = GetConnection.getMysqlConnection().prepareStatement(sql);
            gc.rs =gc.ps.executeQuery();

            while (gc.rs.next()){
                bal[0]=gc.rs.getInt(1);
                bal[1]=gc.rs.getInt(2);
            }
            return bal;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                gc.ps.close();
                gc.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
