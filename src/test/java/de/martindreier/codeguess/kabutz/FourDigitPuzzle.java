/**
 * (c) 2020, SAP SE
 */
package de.martindreier.codeguess.kabutz;

import java.util.List;
import java.util.Set;

import de.martindreier.codeguess.Hint;

/**
 * Puzzle posted by Heinz Kabutz on Twitter.
 * 
 * @see https://twitter.com/heinzkabutz/status/1283343565842718720
 * @author D043987
 *
 */
public class FourDigitPuzzle extends PuzzleBase {
	
	@Override
	protected int getResultSize() {
		return 4;
	}
	
	@Override
	protected Set<Hint> createHints() {
		return Set.of(
			//3412 - one digit is right, but in the wrong place
			new Hint(List.of(3, 4, 1, 2), 1, 0),
			//1368 - one digit is right, and in its place
			new Hint(List.of(1, 3, 6, 8), 1, 1),
			//7450 - two digits are right, but in the wrong place
			new Hint(List.of(7, 4, 5, 0), 2, 0),
			//6487 - All digits are wrong
			new Hint(List.of(6, 4, 8, 7), 0, 0),
			//9852 - two digits are right, one is in its place and one in the wrong place
			new Hint(List.of(9, 8, 5, 2), 2, 1)
		);
	}
	
	protected Set<List<Integer>> createSolutions() {
		return Set.of(List.of(9, 3, 0, 5));
	}
	
}
