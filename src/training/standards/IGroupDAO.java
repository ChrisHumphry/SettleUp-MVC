package training.standards;

import training.beans.Group;

public interface IGroupDAO {
    boolean insertGroup(String name);
    boolean getGroup(String name);
}