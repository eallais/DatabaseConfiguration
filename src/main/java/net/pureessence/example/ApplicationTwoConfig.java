package net.pureessence.example;

import javax.sql.DataSource;

import org.apache.commons.configuration.ConfigurationConverter;
import org.apache.commons.configuration.DatabaseConfiguration;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ApplicationTwoConfig {

  public ApplicationTwoConfig() {
    super();
  }

  @Bean
  public Person person() {
    return new Person();
  }

  @Bean
  public DataSource dataSource() {
    try {
      return PropertiesDataSourceFactory.createDataSource("databaseForConfiguration.properties");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Bean
  public JdbcTemplate jdbcTemplate() throws Exception {
    return new JdbcTemplate(dataSource());
  }

  @Bean
  public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() throws Exception {
    PropertyPlaceholderConfigurer p = new PropertyPlaceholderConfigurer();
    p.setLocation(new ClassPathResource("env.properties"));
    p.setProperties(ConfigurationConverter.getProperties(databaseConfiguration()));
    return p;
  }

  @Bean
  public DatabaseConfiguration databaseConfiguration() {
    return new DatabaseConfiguration(dataSource(), "configuration", "application", "key", "value",
        Constants.APPLICATION_TWO);
  }

}