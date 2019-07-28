package training.dao;

import training.beans.OwesOwed;
import training.standards.IOwesOwedDAO;
import training.connections.GetConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwesOwedDAO implements IOwesOwedDAO {
    @Override
    public boolean insertOwesOwed(OwesOwed oo) {
        String sql = "insert into owesowed values (?,?,?,?)";
        GetConnection gc = new GetConnection();

        try {

            gc.ps = GetConnection.getMysqlConnection().prepareStatement(sql);
            gc.ps.setInt(1,oo.getOwed() );
            gc.ps.setInt(2,oo.getOwes());
            gc.ps.setString(3,oo.getGroupName());
            gc.ps.setString(4, oo.getUserName());

            return gc.ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public List<OwesOwed> getOwesOwed(String groupName) {

        String sql = "select user_name, owes, owed from owesowed where group_name=? ";
        GetConnection gc=new GetConnection();

        List<OwesOwed> bal = new ArrayList<>();
        try {
            gc.ps = GetConnection.getMysqlConnection().prepareStatement(sql);
            gc.ps.setString(1, groupName);
            gc.rs =gc.ps.executeQuery();
            
            while (gc.rs.next()){
            	OwesOwed oo=new OwesOwed();
            	oo.setUserName(gc.rs.getString("user_name"));
                oo.setOwed(gc.rs.getInt("owed"));
                oo.setOwes(gc.rs.getInt("owes"));
                oo.setGroupName(groupName);
                bal.add(oo);
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