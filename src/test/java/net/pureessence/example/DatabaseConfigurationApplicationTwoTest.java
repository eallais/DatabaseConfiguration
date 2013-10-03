package net.pureessence.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = { ApplicationTwoConfig.class })
public class DatabaseConfigurationApplicationTwoTest
    extends AbstractDatabaseConfigurationTest {
  @Autowired
  @Qualifier("person")
  private Person person;

  @SuppressWarnings("deprecation")
  @Test
  public void testPropertiesPrinter() {
    int totalConfigurations = jdbcTemplate.queryForInt("select count(*) from configuration");
    assertEquals(6, totalConfigurations);
    int configurationsForAlpha = jdbcTemplate.queryForInt("select count(*) from configuration where application='"
        + Constants.APPLICATION_TWO + "'");
    assertEquals(3, configurationsForAlpha);
    assertEquals(APPLICATION_TWO_FIRST_NAME, person.getFirstName());
    assertEquals(APPLICATION_TWO_LAST_NAME, person.getLastName());
    assertEquals(APPLICATION_TWO_EMAIL, person.getEmail());
    assertEquals(getEnvProperty(ENV_CAR_PROPERTY), person.getCar());
  }
}