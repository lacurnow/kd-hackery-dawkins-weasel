package actions

import jobs.dawkinsWeaselJobs.{emptyArray, initialString}

import scala.util.Random

/*
- Start with a random string of 28 characters.
- Make 100 copies of the string (reproduce).
- For each character in each of the 100 copies, with a probability of 5%, replace (mutate) the character with a new random character.
- Compare each new string with the target string “METHINKS IT IS LIKE A WEASEL”, and give each a score (the number of letters in the string that are correct and in the correct position).
- If any of the new strings has a perfect score (28), halt. Otherwise, take the highest scoring string, and go to step 2.
*/

object dawkinsWeaselActions {

  val targetString = "METHINKS IT IS LIKE A WEASEL"

  // Function to get a random char.
  // Function to get a string of 28 random chars.
  // Function to mutate a character with a x (5%) probability.
  // Function to duplicate string with 100 copies
  // Function to compare string with target string and generate similarity score.
  // Function to find highest scoring string / perfect string.

  def randomChar: Char = {
    val randomInt = Random.nextInt(27)
    val letterArray = " ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    letterArray(randomInt)
  }

  def generateRandomString(acc: Int = 0, string: String = ""): String = {
    if (acc >= 28) {
      string
    } else {
      generateRandomString(acc + 1, string + randomChar)
    }
  }

  def mutateChar(originalLetter: Char): Char = {
    val randomInt = Random.nextInt(100)
    if (randomInt < 5) {
      randomChar
    } else {
      originalLetter
    }
  }

  def mutateString(stringToMutate: String): String = {
    stringToMutate.map(letter => mutateChar(letter))
  }

  def reproduceString(acc: Int = 0, stringToReproduce: String, array: Array[String]): Array[String] = {
    if (acc >= 100) {
      array
    } else {
      val newDuplicateString = mutateString(stringToReproduce)
      reproduceString(acc + 1, stringToReproduce, array :+ newDuplicateString)
    }
  }

  def stringComparisonScore(stringToCompare: String): Int = {
    val zippedStrings: Seq[(Char, Char)] = targetString.zip(stringToCompare)
    val matchingCharScore = zippedStrings.foldLeft(0)((count, characterPair) => if (characterPair._1 == characterPair._2) {
      count + 1
    } else {
      count
    })
    matchingCharScore
  }

  def stringRanker(reproducedStrings: Array[String]): (String, Int) = {
    val stringsWithScores = reproducedStrings.map(string => (string, stringComparisonScore(string)))
    stringsWithScores.maxBy(_._2)
  }

  def findOurWeasel(string: String = initialString): String = {
    val hundredStrings = reproduceString(0, string, emptyArray)
    val currentBestString =stringRanker(hundredStrings)
    if (winOrRepeat(currentBestString) == "winner") {
      println("winner winner weasel dinner!: " + currentBestString)// put time here
    }
    currentBestString._1
  }

  def winOrRepeat(bestString: (String, Int)): String = {
    val score = bestString._2
    if (score == 28) {
      "winner"
    } else {
      findOurWeasel(bestString._1)
    }
  }

}