package jobs

import actions.dawkinsWeaselActions.{findOurWeasel, generateRandomString, reproduceString, stringComparisonScore, stringRanker, winOrRepeat}

/*
- Start with a random string of 28 characters.
- Make 100 copies of the string (reproduce).
- For each character in each of the 100 copies, with a probability of 5%, replace (mutate) the character with a new random character.
- Compare each new string with the target string “METHINKS IT IS LIKE A WEASEL”, and give each a score (the number of letters in the string that are correct and in the correct position).
- If any of the new strings has a perfect score (28), halt. Otherwise, take the highest scoring string, and go to step 2.
*/

object dawkinsWeaselJobs extends App {
  val initialString = generateRandomString()
  val emptyArray = Array[String]()
  findOurWeasel()
//  println(stringComparisonScore("SHFNDLEO DO IC FOUR QXHIPPIE"))
}
