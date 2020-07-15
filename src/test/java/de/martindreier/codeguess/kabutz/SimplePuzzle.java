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
 * @see https://twitter.com/heinzkabutz/status/1283087967632990209
 * @author D043987
 *
 */
public class SimplePuzzle extends PuzzleBase {
	
	@Override
	protected int getResultSize() {
		return 3;
	}
	
	@Override
	protected Set<Hint> createHints() {
		return Set.of(
			//147 - one digit is right but in the wrong place
			new Hint(List.of(1, 4, 7), 1, 0),
			//189 - one digit is right and in its place
			new Hint(List.of(1, 8, 9), 1, 1),
			//964 - two digits are right but both are in the wrong place
			new Hint(List.of(9, 6, 4), 2, 0),
			//523 - all digits are wrong
			new Hint(List.of(5, 2, 3), 0, 0),
			//286 - one digit is right but in the wrong place
			new Hint(List.of(2, 8, 6), 1, 0)
		);
	}
	
	protected Set<List<Integer>> createSolutions() {
		return Set.of(List.of(6, 7, 9));
	}
	
}
