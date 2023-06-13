package com.develogical;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QueryProcessor {

  String patternAddition = "What is (\\d+) plus (\\d+)\\?";
    String patternAdditionMultiple = "What is (\\d+) plus (\\d+) plus (\\d+)\\?";

  String patternHighestOfThree = "Which of the following numbers is the largest: (\\d+), (\\d+), (\\d+)\\?";
  String patternSquareCube = "Which of the following numbers is both a square and a cube:";
  String patternPrimes = "Which of the following numbers are primes:";
    String patternMinus = "What is (\\d+) minus (\\d+)\\?";
  String patternMultiplication = "What is (\\d+) multiplied by (\\d+)\\?";
  String patternDivisionString = "What is (\\d+) divided by (\\d+)\\?";
// What is 25 to the power of 69?
  String powerPattern = "What is (\\d+) to the power of (\\d+)\\?";


  public String process(String query) {

    System.out.println("Received query:" + query);

    if (query.toLowerCase().contains("what is your name?")) {
      return "TeamBrasil";
    }

    if (query.matches(patternAddition)) {
        String[] parts = query.split(" ");
        int num1 = Integer.parseInt(parts[2]);
        int num2 = Integer.parseInt(parts[4].substring(0, parts[4].length() - 1));
        return String.valueOf(num1 + num2);
    }

    if (query.matches(patternAdditionMultiple)) {
      String[] parts = query.split(" ");
        int num1 = Integer.parseInt(parts[2]);
        int num2 = Integer.parseInt(parts[4]);
        int num3 = Integer.parseInt(parts[6].substring(0, parts[6].length() - 1));

        return String.valueOf(num1 + num2 + num3);
    }
    
    if (query.matches(powerPattern)) {
        String[] parts = query.split(" ");
        int num1 = Integer.parseInt(parts[2]);
        int num2 = Integer.parseInt(parts[7].substring(0, parts[7].length() - 1));
        return String.valueOf(Math.pow(num1, num2));
    }

      if (query.matches(patternMinus)) {
        String[] parts = query.split(" ");
        int num1 = Integer.parseInt(parts[2]);
        int num2 = Integer.parseInt(parts[4].substring(0, parts[4].length() - 1));
        return String.valueOf(num1 - num2);
    }

    if (query.startsWith(patternSquareCube)) {
        int[] parts = extractNumbersAfterColon(query);
        List<Integer> res = new ArrayList<Integer>();

        for (int part: parts) {
          if (isSquareAndCube((part))){
            res.add(part);
          }
    
        }
        return res.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    if (query.startsWith(patternPrimes)) {
        int[] parts = extractNumbersAfterColon(query);
        List<Integer> primes = new ArrayList<Integer>();
        for (int part: parts) {
          if (isPrime((part))) {
            primes.add(part);
          }
        }
        return primes.stream().map(String::valueOf).collect(Collectors.joining(", "));

    }

    if (query.matches(patternMultiplication)) {
        String[] parts = query.split(" ");
        int num1 = Integer.parseInt(parts[2]);
        int num2 = Integer.parseInt(parts[5].substring(0, parts[5].length() - 1));
        return String.valueOf(num1 * num2);
    }

    if (query.matches(patternDivisionString)) {
        String[] parts = query.split(" ");
        Double num1 = Double.parseDouble(parts[2]);
        Double num2 = Double.parseDouble(parts[5].substring(0, parts[5].length() - 1));
        return String.valueOf(num1 / num2);
    }

    if (query.matches(patternHighestOfThree)) {
        String afterColon = query.substring(query.indexOf(':')+1, query.length() - 1);
        String[] parts = afterColon.split(", ");
        int num1 = Integer.parseInt(parts[0].trim());
        int num2 = Integer.parseInt(parts[1].trim());
        int num3 = Integer.parseInt(parts[2].trim());
        return String.valueOf(Math.max(Math.max(num1, num2), num3));
    }


    if (query.toLowerCase().contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
          + "English poet, playwright, and actor, widely regarded as the greatest "
          + "writer in the English language and the world's pre-eminent dramatist.";
    }

    return "";
  }

  private int[] extractNumbersAfterColon(String query) {
    String afterColon = query.substring(query.indexOf(':')+1, query.length() - 1);
    String[] parts = afterColon.split(", ");
    int[] ints = new int[parts.length];
    for (int i = 0; i < parts.length; i++ ) {
      ints[i] = Integer.valueOf(parts[i].trim());
    }
    return ints;
  }

    private static boolean isSquareAndCube(int number) {
        double squareRoot = Math.sqrt(number);
        double cubeRoot = Math.cbrt(number);
        return isInteger(squareRoot) && isInteger(cubeRoot);
    }

    private static boolean isInteger(double number) {
        return Math.floor(number) == number;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        // Check divisibility from 2 to the square root of the number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Not prime if divisible by any number
            }
        }

        return true; // Prime if not divisible by any number
    }
}
