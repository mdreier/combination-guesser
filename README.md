# Combination Guesser

This project guesses a combination of digits based on hints. The hints take the form of

> 1234 - One number is correct and in its place

> 2345 - Two numbers are correct and one is in its place

> 7890 - No numbers are correct

(the above does not produce a unique combination)

This project is based on a series of puzzles posted on Twitter by Heinz Kabutz:

- https://twitter.com/heinzkabutz/status/1283087967632990209
- https://twitter.com/heinzkabutz/status/1283343565842718720
- https://twitter.com/heinzkabutz/status/1283349166886989830

Unit tests based on these puzzles are included (see [here](https://github.com/mdreier/combination-guesser/tree/main/src/test/java/de/martindreier/codeguess/kabutz)).