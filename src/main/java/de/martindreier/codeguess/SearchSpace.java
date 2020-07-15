/**
 * (c) 2020, SAP SE
 */
package de.martindreier.codeguess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Determine the initial search space.
 * This class is not thread safe.
 * 
 * @author D043987
 *
 */
public class SearchSpace {
	private Collection<Hint> hints;
	private List<Set<Integer>> positionalSearchSpace;

	public SearchSpace(Collection<Hint> hints) {
		this.hints = hints;
	}
	
	public Set<List<Integer>> determine(int resultSize) {
		if (positionalSearchSpace == null)
		{
			Set<Integer> globalSearchSpace = determineGlobalSearchSpace();
			positionalSearchSpace = new ArrayList<Set<Integer>>(resultSize);
			for (int index = 0; index < resultSize; index++)
			{
				positionalSearchSpace.add(new HashSet<>(globalSearchSpace));
			}
		}
		return new Permutation(positionalSearchSpace).getAllCombinations();
	}
	
	private Set<Integer> determineGlobalSearchSpace() {
		Set<Integer> globalSearchSpace = new HashSet<>(Set.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		removeAllIncorrects(globalSearchSpace);
		return globalSearchSpace;
	}

	/**
	 * Remove all numbers from hints where all digits are incorrect
	 * @param searchSpace
	 */
	protected void removeAllIncorrects(Set<Integer> searchSpace)
	{
		hints.forEach(hint -> {
			if (hint.correctDigits() == 0) {
				searchSpace.removeAll(hint.numbers());
			}
		});
	}
}
