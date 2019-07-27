package training.beans;

public class OwesOwed {
	private int owed;
	private int owes;
	private String groupName;
	private String userName;
	
	public OwesOwed(int owed, int owes, String groupName, String userName) {
		super();
		this.owed = owed;
		this.owes = owes;
		this.groupName = groupName;
		this.userName = userName;
	}
	public OwesOwed() {
		
	}
	public int getOwed() {
		return owed;
	}
	public void setOwed(int owed) {
		this.owed = owed;
	}
	public int getOwes() {
		return owes;
	}
	public void setOwes(int owes) {
		this.owes = owes;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
}
}