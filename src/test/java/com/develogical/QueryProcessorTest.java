package com.develogical;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }

  @Test
  public void knowsAboutShakespeare() throws Exception {
    assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
  }

  @Test
  public void returnsWhatIsOurName() throws Exception {
    assertThat(queryProcessor.process("what is your name?"), is("TeamBrasil"));
  }

  @Test
  public void returnsCorrectAddition() throws Exception {
    assertThat(queryProcessor.process("What is 70 plus 25?"), is("95"));
  }

  @Test
  public void returnsCorrectMinus() throws Exception {
    assertThat(queryProcessor.process("What is 70 minus 25?"), is("45"));
  }

  @Test
  public void returnsHighest() throws Exception {
    assertThat(queryProcessor.process("Which of the following numbers is the largest: 47, 83, 48?"), is("83"));
  }

  @Test
  public void returnsHighest2() throws Exception {
    assertThat(queryProcessor.process("Which of the following numbers is the largest: 93, 34, 39?"), is("93"));
  }

  @Test
  public void returnsCorrectMultiplication() throws Exception {
    assertThat(queryProcessor.process("What is 72 multiplied by 35?"), is("2520"));
  }

  @Test
  public void returnsCorrectDivision() throws Exception {
    assertThat(queryProcessor.process("What is 3 divided by 2?"), is("1.5"));
  }


  @Test
  public void returnsSquareAndCube() throws Exception {
      assertThat(queryProcessor.process("Which of the following numbers is both a square and a cube: 729, 2197, 1849, 25, 3441, 3211, 936?"), is("729"));
  }


    @Test
  public void returnsSquareAndCube2() throws Exception {
      assertThat(queryProcessor.process("Which of the following numbers is both a square and a cube: 2181, 4031, 4096, 3922, 181, 841, 729?"), is("4096, 729"));
  }

  @Test
  public void returnsPrime() throws Exception {
      assertThat(queryProcessor.process("Which of the following numbers are primes: 25, 97, 7, 22, 13?"), is("97, 7, 13"));
  }

}


