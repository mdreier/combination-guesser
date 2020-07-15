package de.martindreier.codeguess;
/**
 * (c) 2020, SAP SE
 */

import java.util.Collection;
import java.util.List;
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
		checkHintLength(hints);
		Collection<List<Integer>> guesses = new SearchSpace(hints).determine(resultSize);
		return limitGuessesByHints(guesses, hints);
	}

	private void checkHintLength(Collection<Hint> hints) {
		for (Hint hint: hints)
		{
			if (hint.numbers().size() != resultSize)
			{
				throw new IllegalArgumentException(String.format("Hint \"%s\" does not have the correct length (%d)", hint, resultSize));
			}
		}
	}

	/**
	 * Brute force approach: Remove all guesses which are not allowed by hints.
	 * @param guesses The guesses.
	 * @param hints The hints.
	 * @return Filtered guesses.
	 */
	private Collection<List<Integer>> limitGuessesByHints(Collection<List<Integer>> guesses, Collection<Hint> hints) {
		Stream<List<Integer>> filtered = guesses.parallelStream();
		for (Hint hint: hints)
		{
			filtered = filtered.filter(hint::allows);
		}
		return filtered.collect(Collectors.toSet());
	}
}
