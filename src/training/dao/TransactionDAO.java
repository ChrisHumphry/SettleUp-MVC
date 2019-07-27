package training.dao;

import training.beans.OwesOwed;
import training.beans.Transaction;
import training.connections.GetConnection;
import training.standards.ITransactionDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO implements ITransactionDAO {
    @Override
    public boolean insertTransaction(Transaction transaction) {
        String sql = "insert into groups values (?,?,?,?)";
        GetConnection gc = new GetConnection();

        try {

            gc.ps = GetConnection.getMysqlConnection().prepareStatement(sql);
            gc.ps.setInt(1, transaction.getId());  
            gc.ps.setBigDecimal(2,transaction.getAmount());
            gc.ps.setString(3, transaction.getCreator());
            gc.ps.setString(4,transaction.getGroupName());

            return gc.ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Transaction> getTransactionsByGroup(String groupName) {
    	String sql = "select id,user_name,amount from transactions where group_name=? ";
        GetConnection gc=new GetConnection();

        List<Transaction> trans = new ArrayList<>();
        try {
            gc.ps = GetConnection.getMysqlConnection().prepareStatement(sql);
            gc.rs =gc.ps.executeQuery();
            
            while (gc.rs.next()){
            	Transaction t=new Transaction();
            	t.setCreator(gc.rs.getString("user_name"));
            	t.setAmount(gc.rs.getBigDecimal("amount"));
            	t.setId(gc.rs.getInt("id"));
            	t.setGroupName(groupName);
                
            	trans.add(t);
            }
            return trans;

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