/**
 * (c) 2020, SAP SE
 */
package de.martindreier.codeguess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Calculate permutations for a positional search space.
 * 
 * @author D043987
 *
 */
public class Permutation {
	private List<Set<Integer>> positionalSearchSpace;
	private Set<List<Integer>> results;
	private List<Integer> guess;

	/**
	 * Create the permutation instance.
	 * 
	 * @param positionalSearchSpace The search space for each position.
	 */
	public Permutation(List<Set<Integer>> positionalSearchSpace) {
		assert positionalSearchSpace != null;
		this.positionalSearchSpace = positionalSearchSpace;
		this.guess = new ArrayList<>(positionalSearchSpace.size());
	}

	public Set<List<Integer>> getAllCombinations() {
		if (results == null) {
			results = new HashSet<>();
			if (positionalSearchSpace.size() > 0)
			{
				fillRecursive();
			}
		}
		return results;
	}

	protected void fillRecursive() {
		if (isComplete()) {
			results.add(new ArrayList<>(guess));
		} else {
			int position = guess.size();
			for (Integer digit : positionalSearchSpace.get(position)) {
				guess.add(digit);
				fillRecursive();
				guess.remove(guess.size() - 1);
			}
		}
	}

	private boolean isComplete() {
		return guess.size() == positionalSearchSpace.size();
	}
}
