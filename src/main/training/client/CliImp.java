package main.training.client;

import org.apache.log4j.Logger;
import main.training.beans.Group;
import main.training.beans.User;
import main.training.dao.GroupDAO;
import main.training.dao.UserDAO;
import main.training.standards.IGroupDAO;
import main.training.standards.IUserDAO;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashSet;
import java.util.Scanner;

public class CliImp {
    static Logger log = Logger.getLogger(CliImp.class.getName());
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        while (true) {
            System.out.println("1. Enter User \t 2. Enter New Group \t 3. Enter New Transaction \t 4. Exit");
            Scanner in = new Scanner(System.in);
            int choice = Integer.parseInt(in.nextLine());
            HashSet<User> set = new HashSet<>();
            Group g1;
            switch (choice) {
                case 1:
                    User u1 = new User(getUser());
                    u1.setId(12);
                    System.out.println("Created [" + u1 + "] successfully");
                    IUserDAO userDAO = new UserDAO();
                    log.debug("our first debug");
                    userDAO.insertUser(u1);
                    break;
                case 2:
                    int userId;
                    System.out.println("Enter users and enter 0 for exiting : ");
                    while (true) {
                        userId = Integer.parseInt(in.nextLine());
                        if (userId != 0) {
                            int u = getUserID();
                            //set.add(u);
                        } else {
                            break;
                        }
                    }
                    g1 = new Group(set, getGroup());
                    IGroupDAO groupDAO = new GroupDAO();
                    groupDAO.insertGroup(g1);
                    System.out.println(g1);
                    break;
                case 3:
//                    g1=getGroupSer();
//                    g1.addTxns(new Transaction(getTransactionAmount(), getUserFromArrayList(getUser())));
                   // System.out.println(g1);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Wrong Input");
                    ;
            }
        }
    }

    private static int getUserID() {
        System.out.println("Enter userid ");
        Scanner scanner = new Scanner(System.in);
        return  Integer.parseInt(scanner.nextLine());
    }

    private static BigDecimal getTransactionAmount() {
        System.out.println("Enter Transaction Amount ");
        Scanner scanner = new Scanner(System.in);
        BigDecimal i = new BigDecimal(Double.parseDouble(scanner.nextLine()), MathContext.DECIMAL64);
        if (i.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("Amount cannot be negative");
        } else return i;
        return BigDecimal.ZERO;
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
