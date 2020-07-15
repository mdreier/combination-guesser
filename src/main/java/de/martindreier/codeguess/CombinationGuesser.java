package de.martindreier.codeguess;
/**
 * (c) 2020, SAP SE
 */

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author D043987
 *
 */
public class CombinationGuesser {
	private int resultSize;

	/**
	 * Create a new instance.
	 * @param resultSize Number of digits in the result.
	 */
	public CombinationGuesser(int resultSize)
	{
		this.resultSize = resultSize;
	}
	
	public Collection<List<Integer>> guess(Collection<Hint> hints) {
		
		Set<List<Integer>> guesses = new SearchSpace(resultSize, hints).determine();
		return limitGuessesByHints(guesses, hints);
	}

	private Collection<List<Integer>> limitGuessesByHints(Set<List<Integer>> guesses, Collection<Hint> hints) {
		Stream<List<Integer>> filtered = guesses.parallelStream();
		for (Hint hint: hints)
		{
			filtered = filtered.filter(hint::allows);
		}
		return filtered.collect(Collectors.toSet());
	}
}
