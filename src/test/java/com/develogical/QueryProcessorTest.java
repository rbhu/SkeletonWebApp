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
    assertThat(queryProcessor.process("what is 43 plus 10?"), is("53"));
  }
}
