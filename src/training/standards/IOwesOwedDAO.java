package training.standards;

import java.util.List;

import training.beans.Group;
import training.beans.OwesOwed;
import training.beans.User;

public interface IOwesOwedDAO {
    
    List<OwesOwed> getOwesOwed(String groupName);
	boolean insertOwesOwed(OwesOwed oo);
}

