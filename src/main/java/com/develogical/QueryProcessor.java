package com.develogical;


public class QueryProcessor {

  String patternAddition = "What is (\\d+) plus (\\d+)\\?";
  String patternHighestOfThree = "Which of the following numbers is the largest: (\\d+), (\\d+), (\\d+)\\?";
  String patternSquareCube = "Which of the following numbers is both a square and a cube:";

  String patternMultiplication = "What is (\\d+) multiplied by (\\d+)\\?";


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

    if (query.startsWith(patternSquareCube)) {
        int[] parts = extractNumbersAfterColon(query);
        for (int part: parts) {
          if (isSquareAndCube((part))) return String.valueOf(part);
        }

    }

    if (query.matches(patternMultiplication)) {
        String[] parts = query.split(" ");
        int num1 = Integer.parseInt(parts[2]);
        int num2 = Integer.parseInt(parts[5].substring(0, parts[5].length() - 1));
        return String.valueOf(num1 * num2);
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
}
