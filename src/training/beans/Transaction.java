package training.beans;

import java.math.BigDecimal;

public class Transaction{
    private int id;
    private BigDecimal amount;
    private String creator;
    private String groupName;

    public Transaction(int id, BigDecimal amount,String creator, String groupName) {
        this.id = id;
        this.amount = amount;
        this.creator = creator;
        this.groupName = groupName;
    }

    public void setCreator(String creator) {
		this.creator = creator;
	}

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCreator() {
        return creator;
    }

	public void setAmount(BigDecimal bigDecimal) {
		// TODO Auto-generated method stub
		this.amount=bigDecimal;
		
	}


}