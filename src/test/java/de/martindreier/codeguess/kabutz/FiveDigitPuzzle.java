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
 * @see https://twitter.com/heinzkabutz/status/1283349166886989830
 * @author D043987
 *
 */
public class FiveDigitPuzzle extends PuzzleBase {
	
	@Override
	protected int getResultSize() {
		return 5;
	}
	
	@Override
	protected Set<Hint> createHints() {
		return Set.of(
			//65032 - Two digits are right, one in its place and one in the wrong place
			new Hint(List.of(6, 5, 0, 3, 2), 2, 1),
			//18695 - One digits is right, and in its place
			new Hint(List.of(1, 8, 6, 9, 5), 1, 1),
			//98721 - All digits are wrong
			new Hint(List.of(9, 8, 7, 2, 1), 0, 0),
			//13579 - Two digits are right, but in the wrong place
			new Hint(List.of(1, 3, 5, 7, 9), 2, 0)
		);
	}
	
	protected Set<List<Integer>> createSolutions() {
		return Set.of(List.of(4, 4, 4, 3, 5));
	}
	
}
