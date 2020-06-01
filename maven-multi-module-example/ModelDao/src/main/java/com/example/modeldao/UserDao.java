package com.example.modeldao;

import com.example.daoapi.UserDaoApi;
import com.github.javafaker.Faker;

import java.util.*;

public class UserDao implements UserDaoApi<User> {

  private List<User> users = new ArrayList<>();

  private int userLimit;

  public UserDao(int userLimit) {

    this.userLimit=userLimit;
    generateUsers();
  }

  private void generateUsers() {
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
public User getRandomUser(){
      int min=0,max=userLimit;
    Random r = new Random();
    int int_random= r.nextInt((max - min)) + min;
  return users.get(int_random);
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

    //Simple Linear iteration for sake of simplicity
    ListIterator<User> listItr= users.listIterator();

    while(listItr.hasNext()){
      User currentUser= listItr.next();
      if(currentUser.getId()==user.getId()){

        currentUser.setFistName(Objects.requireNonNull(
                params[0], "Fist name cannot be null"));
        currentUser.setLastName(Objects.requireNonNull(
                params[1], "Last name cannot be null"));
        currentUser.setEmail(Objects.requireNonNull(
                params[2], "Email cannot be null"));
      }
    }
  }

  @Override
  public void delete(User user) {
    users.remove(user);
  }
}
