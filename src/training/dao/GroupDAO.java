package training.dao;

import training.beans.Group;
import training.beans.OwesOwed;
import training.connections.GetConnection;
import training.standards.IGroupDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO implements IGroupDAO {
    @Override
    public boolean insertGroup(String name) {
        String sql = "insert into groups values (?)";
        GetConnection gc = new GetConnection();

        try {

            gc.ps = GetConnection.getMysqlConnection().prepareStatement(sql);
            
            gc.ps.setString(1, name);

            return gc.ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public boolean getGroup(String name) {
		 String sql = "select name from groups where name=? ";
	        GetConnection gc=new GetConnection();

	        try {
	            gc.ps = GetConnection.getMysqlConnection().prepareStatement(sql);
	            gc.ps.setString(1, name);
	            gc.rs =gc.ps.executeQuery();
	            
	            if(gc.rs.next())
	            	return true;

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
		return false;
	}
}