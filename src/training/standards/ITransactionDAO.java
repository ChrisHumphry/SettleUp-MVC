package training.standards;

import training.beans.Transaction;

import java.util.List;

public interface ITransactionDAO {
    boolean insertTransaction(Transaction transaction);
    List<Transaction> getTransactionsByGroup(String groupName);

}