package net.pureessence.example;

import org.springframework.beans.factory.annotation.Value;

public class Person {

  @Value("${first.name}")
  private String firstName;

  @Value("${last.name}")
  private String lastName;

  @Value("${car}")
  private String car;

  @Value("${email}")
  private String email;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCar() {
    return car;
  }

  public void setCar(String car) {
    this.car = car;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}