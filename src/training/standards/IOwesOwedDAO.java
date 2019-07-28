package training.standards;

import java.util.List;

import training.beans.OwesOwed;

public interface IOwesOwedDAO {
    List<OwesOwed> getOwesOwed(String groupName);
	boolean insertOwesOwed(OwesOwed oo);
}

