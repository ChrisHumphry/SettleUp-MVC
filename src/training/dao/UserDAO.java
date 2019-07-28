package training.dao;

import training.beans.User;
import training.connections.GetConnection;
import training.standards.IUserDAO;

import java.sql.SQLException;

public class UserDAO implements IUserDAO {
    @Override
    public boolean insertUser(User user) {

        String sql = "insert into users values (?,?,?)";
        GetConnection gc = new GetConnection();

        try {

            gc.ps = GetConnection.getMysqlConnection().prepareStatement(sql);
           
            gc.ps.setString(1, user.getName());
            gc.ps.setString(2,user.getPassword());

            return gc.ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

	@Override
	public User getUser(String name) {
		String sql = "select name,password from user where name=?";
        GetConnection gc=new GetConnection();

        try {
            gc.ps = GetConnection.getMysqlConnection().prepareStatement(sql);
            gc.ps.setString(1,name);
            gc.rs =gc.ps.executeQuery();

            if (gc.rs.next()){

                User user= new User();
                user.setName(gc.rs.getString("name"));
                user.setPassword(gc.rs.getString("password"));
                
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
}