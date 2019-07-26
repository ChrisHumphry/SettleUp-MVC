package training.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
    in the hashmap <u,arr[0]>=user owes,<u,arr[1]>=user is owed
 */
public class Group {

    private int id;
    private int noOfUsers;
    private HashSet<User> users;
    private String name;
    private ArrayList<Transaction> txns;
    private HashMap<User, BigDecimal[]> map;



    @Override
    public String toString() {
        for (User u : map.keySet()) {
            System.out.println(u + "owes " + map.get(u)[0] + " and is owed " + map.get(u)[1]);
        }
        return "Group{" +
                "users=" + printHashSet(users) +
                ", name='" + name + '\'' +
                ", txns=" + txns +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group(HashSet<User> users, String name) {
        this.users = users;
        this.name = name;
        this.noOfUsers = users.size();
        this.txns = new ArrayList<Transaction>();
        this.map = new HashMap<User, BigDecimal[]>();
        for (User u : users) {
            this.map.put(u, new BigDecimal[]{BigDecimal.ZERO, BigDecimal.ZERO});
        }
    }

    public String printHashSet(HashSet<User> user) {
        for (User temp : user) {
            return (temp.toString());
        }
        return "";
    }

    public HashMap<User, BigDecimal[]> getMap() {
        return map;
    }

    public void setMap(HashMap<User, BigDecimal[]> map) {
        this.map = map;
    }

    public HashSet<User> getUsers() {
        return users;
    }

    public void setUsers(HashSet<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Transaction> getTxns() {
        return txns;
    }

    public void addTxns(Transaction txn) {
        BigDecimal temp = txn.getAmount().divide(new BigDecimal(noOfUsers));
        for (User u : users) {
            if (!u.getName().equals(txn.getCreator().getName())) {
                this.map.get(u)[0].add(temp) ;
            }

        }

        map.get(txn.getCreator())[1].add(txn.getAmount().subtract(temp));
        txns.add(0, txn);
    }
}
