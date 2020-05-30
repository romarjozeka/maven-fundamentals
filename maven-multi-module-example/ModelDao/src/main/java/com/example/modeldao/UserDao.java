package com.example.modeldao;

import com.example.daoapi.UserDaoApi;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserDao implements UserDaoApi<User> {

  private List<User> users = new ArrayList<>();

  private int userLimit;

  public UserDao(int userLimit) {

    generateUsers(userLimit);
  }

  private void generateUsers(int userLimit) {
    //Info message
    System.out.println("Generating "+userLimit+" users...");

    for (int i = 0; i < userLimit; i++) {
      Faker faker = new Faker();
      long id = faker.number().randomNumber();
      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();
      String email= faker.internet().safeEmailAddress();

      users.add(new User(id,firstName,lastName,email));
    }
    System.out.println("Users generated.");

  }


  public int getUserLimit() {
    return userLimit;
  }

  public void setUserLimit(int userLimit) {
    this.userLimit = userLimit;
  }

  @Override
  public List<User> getAll() {
    return users;
  }

  @Override
  public Optional<User> get(long id) {
    return Optional.ofNullable(users.get((int) id));
  }

  @Override
  public void save(User user) {
    users.add(user);
  }

  @Override
  public void update(User user, String[] params) {
    user.setFistName(Objects.requireNonNull(
            params[0], "Fist name cannot be null"));
    user.setLastName(Objects.requireNonNull(
            params[1], "Fist name cannot be null"));
    user.setEmail(Objects.requireNonNull(
            params[2], "Email cannot be null"));

    users.add(user);
  }

  @Override
  public void delete(User user) {
    users.remove(user);
  }
}
