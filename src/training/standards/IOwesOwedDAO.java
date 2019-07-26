package training.standards;

import training.beans.Group;
import training.beans.User;

public interface IOwesOwedDAO {
    boolean insertOwesOwed(User user, Group group, int owes, int owed);
    int[] getOwesOwed(User user, Group group);
}
