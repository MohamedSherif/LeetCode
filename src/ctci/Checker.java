package ctci;

import java.util.Comparator;

public class Checker implements Comparator<Player> {

	@Override
	/**
	 * x.compareTo(Y): 
	 * 	Negative value: if x < y (X should appear first) 
	 * 	Zero : if x == y 
	 * 	Positive Value: if x > y (X should appear second)
	 */
	public int compare(Player a, Player b) {
		if (a.score == b.score) {
			return a.name.compareTo(b.name);
		}

		return b.score - a.score;
	}

}
