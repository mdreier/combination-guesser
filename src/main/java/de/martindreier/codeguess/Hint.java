/**
 * (c) 2020, SAP SE
 */
package de.martindreier.codeguess;

import java.util.ArrayList;
import java.util.List;

/**
 * A hint for the combination.
 * 
 * @author D043987
 *
 */
public record Hint(List<Integer> numbers, int correctDigits, int digitsInCorrectLocation) {
	@Override
	public String toString() {
		List<String> elements = new ArrayList<>(numbers().size());
		for (int element: numbers()) {
			elements.add(Integer.toString(element));
		}
		return String.format("%s - %d digits are correct and %d are in their place", String.join("", elements), correctDigits(), digitsInCorrectLocation());
	}

	/**
	 * Check if the hint allows the given guess.
	 * @param guess Guess to validate.
	 * @return <code>true</code> if the hint allows the guess, <code>false</code> if not.
	 */
	public boolean allows(List<Integer> guess) {
		int inCorrectPlace = 0, inWrongPlace = 0;
		for (int index = 0; index < guess.size(); index++)
		{
			if (digitIsInCorrectPlace(guess, index))
			{
				inCorrectPlace++;
			} else if (digitIsCorrectButInWrongPlace(guess, index)) {
				inWrongPlace++;
			}
		}
		return inCorrectPlace == digitsInCorrectLocation() && inWrongPlace == correctDigits() - digitsInCorrectLocation();
	}
	
	private boolean digitIsInCorrectPlace(List<Integer> guess, int index)
	{
		return guess.get(index).equals(numbers().get(index));
	}
	
	private boolean digitIsCorrectButInWrongPlace(List<Integer>guess, int index)
	{
		for (int other = 0; other < guess.size(); other++)
		{
			if (other == index)
			{
				continue;
			}
			if (guess.get(index).equals(numbers().get(other)))
			{
				return true;
			}
		}
		return false;
	}
}
