/**
 * (c) 2020, SAP SE
 */
package de.martindreier.codeguess;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.paukov.combinatorics3.Generator;

/**
 * Determine the initial search space.
 * 
 * @author D043987
 *
 */
public class SearchSpace {
	private Collection<Hint> hints;
	private int resultSize;

	public SearchSpace(int resultSize, Collection<Hint> hints) {
		this.resultSize = resultSize;
		this.hints = hints;
	}
	
	public Set<List<Integer>> determine() {
		Set<Integer> searchSpace = new HashSet<>(Set.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		removeAllIncorrects(searchSpace);
		return allPossibleCombinations(searchSpace);
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
	
	private Set<List<Integer>> allPossibleCombinations(Set<Integer> searchSpace) {
		Set<List<Integer>> possibleSolutions = new HashSet<>();
		
		//Generate all possible combinations in the result size
		Generator.combination(searchSpace).multi(resultSize).stream()
		//and all permutations thereof
		.forEach(combo -> Generator.permutation(combo).simple().forEach(possibleSolutions::add));
		
		return possibleSolutions;
	}
}
