package com.develogical;


public class QueryProcessor {

  String pattern = "what is (\\d+) plus (\\d+)\\?";

  public String process(String query) {

    System.out.println("Received query:" + query);

    if (query.toLowerCase().contains("what is your name?")) {
      return "TeamBrasil";
    }

    if (query.matches(pattern)) {
        String[] parts = query.split(" ");
        int num1 = Integer.parseInt(parts[2]);
        int num2 = Integer.parseInt(parts[4].substring(0, parts[4].length() - 1));
        return String.valueOf(num1 + num2);
    }

    if (query.toLowerCase().contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
          + "English poet, playwright, and actor, widely regarded as the greatest "
          + "writer in the English language and the world's pre-eminent dramatist.";
    }

    return "";
  }
}
