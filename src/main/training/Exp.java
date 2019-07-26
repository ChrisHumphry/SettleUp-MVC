package main.training;

import main.training.beans.Group;
import main.training.beans.User;

import java.io.*;
import java.util.*;

public class Exp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Map<User, List<Integer>> bal= new HashMap<User,List<Integer>>();
//        User u1= new User("Anjani");
//        //System.out.println(bal.get(u1));
//        bal.put(u1,new ArrayList<Integer>(Arrays.asList(10,20)));
//        System.out.println(bal.get(u1));

        User u1= new User("Anjani");
        HashMap<User,int[]> map = new HashMap<User,int[]>();
        map.put(u1,new int[]{10,20});
        System.out.println(map.get(u1)[0]);
        map.get(u1)[0]=30;
        System.out.println(map.get(u1)[0]);

        System.out.println(getUserFromArrayList(getUser()));
    }
    private static void storeGroupSer(Group group) throws IOException {
        File file = new File("group.ser");
        ObjectOutputStream oos;
        if (file.exists()) {
            oos = new AppendingObjectOutputStream(new FileOutputStream(file, true));
            System.out.println("existing file");
        } else {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            System.out.println("creating a file");
        }

        oos.writeObject(group);
        oos.close();

        System.out.println("User data serialized");
    }

    private static Group getGroupSer() throws IOException, ClassNotFoundException {
        File file = new File("group.ser");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        Group group = (Group) ois.readObject();
        return group;
    }

    public static User getUserFromArrayList(String userName) throws ClassNotFoundException, IOException {
        ArrayList<User> user = getUserSer();
        for (User temp : user) {
            if (temp.getName().compareTo(userName) != 0) {
                return temp;
            }
        }
        return null;
    }

    private static ArrayList<User> getUserSer() throws IOException {
        File file = new File("users.ser");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User user;
        ArrayList<User> users = new ArrayList<>();
        try {
            while (true) {
                user = (User) ois.readObject();
                users.add(user);
            }
        } catch (EOFException e) {
            //System.out.println("succesfully read");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static void storeUserSer(User user) throws IOException {
        File file = new File("users.ser");
        ObjectOutputStream oos;
        if (file.exists()) {
            oos = new AppendingObjectOutputStream(new FileOutputStream(file, true));
            System.out.println("existing file");
        } else {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            System.out.println("creating a file");
        }

        oos.writeObject(user);
        oos.close();

        System.out.println("User data serialized");
    }

    private static double getTransactionAmount() {
        System.out.println("Enter Transaction Amount ");
        Scanner scanner = new Scanner(System.in);
        double i = Double.parseDouble(scanner.nextLine());
        if (i < 0) {
            System.out.println("Amount cannot be negative");
        } else return i;
        return 0;
    }

    private static String getUser() {

        System.out.println("Enter usernamme ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        return username;
    }

    private static String getGroup() {

        System.out.println("Enter Group name ");
        Scanner scanner = new Scanner(System.in);
        String groupname = scanner.nextLine();
        return groupname;
    }
}
