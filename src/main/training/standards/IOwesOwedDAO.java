package main.training.standards;

import main.training.beans.Group;
import main.training.beans.User;

public interface IOwesOwedDAO {
    boolean insertOwesOwed(User user, Group group, int owes, int owed);
    int[] getOwesOwed(User user, Group group);
}
