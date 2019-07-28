package training.standards;

public interface IGroupDAO {
    boolean insertGroup(String name);
    boolean getGroup(String name);
}