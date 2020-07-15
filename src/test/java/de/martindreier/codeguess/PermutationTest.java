/**
 * (c) 2020, SAP SE
 */
package de.martindreier.codeguess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Test the {@link Permutation} class.
 * 
 * @author D043987
 *
 */
public class PermutationTest {

	/**
	 * Search space has the same size for each position.
	 */
	@Test
	public void allSameSize() {
		List<Set<Integer>> positionalSearchSpace = List.of(Set.of(1, 2), Set.of(1, 2));
		Permutation perm = new Permutation(positionalSearchSpace);

		Set<List<Integer>> expected = Set.of(
				//
				List.of(1, 1),
				//
				List.of(1, 2),
				//
				List.of(2, 1),
				//
				List.of(2, 2)
		);
		
		assertEquals(expected, perm.getAllCombinations());
	}
	
	/**
	 * Search space has different size for each positions.
	 */
	@Test
	public void differentSizes() {
		List<Set<Integer>> positionalSearchSpace = List.of(Set.of(1, 2), Set.of(1, 2, 3));
		Permutation perm = new Permutation(positionalSearchSpace);

		Set<List<Integer>> expected = Set.of(
				//
				List.of(1, 1),
				//
				List.of(1, 2),
				//
				List.of(1, 3),
				//
				List.of(2, 1),
				//
				List.of(2, 2),
				//
				List.of(2, 3)
		);
		
		assertEquals(expected, perm.getAllCombinations());
	}
	
	/**
	 * Test with more than two positions.
	 */
	@Test
	public void manyPositions()
	{
		List<Set<Integer>> positionalSearchSpace = List.of(Set.of(1, 2), Set.of(1, 2), Set.of(1, 2), Set.of(1, 2));
		Permutation perm = new Permutation(positionalSearchSpace);

		Set<List<Integer>> expected = Set.of(
				//
				List.of(1, 1, 1, 1),
				//
				List.of(1, 1, 1, 2),
				//
				List.of(1, 1, 2, 1),
				//
				List.of(1, 1, 2, 2),
				//
				List.of(1, 2, 1, 1),
				//
				List.of(1, 2, 1, 2),
				//
				List.of(1, 2, 2, 1),
				//
				List.of(1, 2, 2, 2),
				//
				List.of(2, 1, 1, 1),
				//
				List.of(2, 1, 1, 2),
				//
				List.of(2, 1, 2, 1),
				//
				List.of(2, 1, 2, 2),
				//
				List.of(2, 2, 1, 1),
				//
				List.of(2, 2, 1, 2),
				//
				List.of(2, 2, 2, 1),
				//
				List.of(2, 2, 2, 2)
		);
		
		assertEquals(expected, perm.getAllCombinations());
	}
	
	/**
	 * Test with empty search space.
	 */
	@Test
	public void emptySearchSpace()
	{
		Permutation perm = new Permutation(Collections.emptyList());
		assertEquals(Collections.emptySet(), perm.getAllCombinations());
	}
	
	/**
	 * Result length 1.
	 */
	@Test
	public void resultLengthOne() {
		List<Set<Integer>> positionalSearchSpace = List.of(Set.of(1, 2));
		Permutation perm = new Permutation(positionalSearchSpace);

		Set<List<Integer>> expected = Set.of(
				//
				List.of(1),
				//
				List.of(2)
		);
		
		assertEquals(expected, perm.getAllCombinations());
	}
}
