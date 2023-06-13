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
}
