/**
 * (c) 2020, SAP SE
 */
package de.martindreier.codeguess.kabutz;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import de.martindreier.codeguess.CombinationGuesser;
import de.martindreier.codeguess.Hint;

/**
 * @author D043987
 *
 */
public abstract class PuzzleBase {
	protected abstract Set<Hint> createHints();
	protected abstract Set<List<Integer>> createSolutions();
	protected abstract int getResultSize();
	
	/**
	 * Output to console.
	 * @param hints Given hints.
	 * @param solutions Solutions by guesser.
	 * @param durationInNanoseconds Runtime in nanoseconds.
	 */
	protected void print(Collection<Hint> hints, Collection<List<Integer>> solutions, long durationInNanoseconds) {
		System.out.println(this.getClass().getSimpleName());
		System.out.println("Hints:");
		for (Hint hint: hints) {
			System.out.println("  " + hint);
		}
		System.out.println("Solutions:");
		for (List<Integer> solution: solutions)
		{
			System.out.println("  " + solution);
		}
		System.out.println(String.format("Took %.3f ms", durationInNanoseconds / 1_000_000.0));
	}
	
	@Test
	public void solvePuzzle() {
		Set<Hint> hints = createHints();
		Set<List<Integer>> correctSolutions = createSolutions();
		
		CombinationGuesser guesser = new CombinationGuesser(getResultSize());
		long start = System.nanoTime();
		Collection<List<Integer>> guessedSolutions = guesser.guess(hints);
		long end = System.nanoTime();

		print(hints, guessedSolutions, end - start);
		
		//Step 1: Assert that all correct solutions are returned
		for (List<Integer> solution: correctSolutions)
		{
			assertTrue(guessedSolutions.contains(solution), String.format("Solution %s is missing", solution));
		}
		
		//Step 2: Assert that no false solutions are returned
		for (List<Integer> solution: guessedSolutions)
		{
			assertTrue(correctSolutions.contains(solution), String.format("Guessed solution %s is incorrect", solution));
		}
	}
}
