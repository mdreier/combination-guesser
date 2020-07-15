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

	public boolean allows(List<Integer> guess) {
		int inCorrectPlace = 0, inWrongPlace = 0;
		for (int index = 0; index < guess.size(); index++)
		{
			if (guess.get(index).equals(numbers().get(index)))
			{
				inCorrectPlace++;
				break;
			}
			for (int other = 0; other < guess.size(); other++)
			{
				if (other == index)
				{
					continue;
				}
				if (guess.get(index).equals(numbers().get(other)))
				{
					inWrongPlace++;
				}
			}
		}
		return inCorrectPlace == digitsInCorrectLocation() && inWrongPlace == correctDigits() - digitsInCorrectLocation();
	}
}
