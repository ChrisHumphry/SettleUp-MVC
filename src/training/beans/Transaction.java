package training.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class Transaction{
    private BigDecimal amount;
    private User creator;

    public Transaction(BigDecimal amount, User creator) {
        this.amount = amount;
        this.creator = creator;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", creator=" + creator +
                '}';
    }

    public User getCreator() {
        return creator;
    }


}
