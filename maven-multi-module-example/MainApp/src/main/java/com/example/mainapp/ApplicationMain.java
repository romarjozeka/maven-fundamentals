package com.example.mainapp;

import com.example.modeldao.User;
import com.example.modeldao.UserDao;

public class ApplicationMain {
  public static void main(String[] args) {
    int userLimit = 5;
    UserDao users = new UserDao(userLimit);

    System.out.println("\nListing all users\n");

    listAll(users);

    User randomUser = users.getRandomUser();

    System.out.println("\nSelected random user to update with id: " + randomUser.getId());

    users.update(randomUser, new String[] {"Romarjo", "Zeka", "romarjozeka@domain.com"});
    System.out.println("Updated\n");

    User randomUser2 = users.getRandomUser();
    System.out.println("\nSelected random user to delete with id: " + randomUser2.getId());

    users.delete(randomUser2);
    System.out.println("Deleted\n");

    users.save(new User(111, "Julie", "julie@domain.com", "newuser@example.com"));
    System.out.println("\nA new user was created");

    System.out.println("\nListing all updated users\n");
    listAll(users);
  }

  public static void listAll(UserDao users) {
    users
        .getAll()
        .forEach(
            user -> {
              System.out.println(
                  user.getId()
                      + " "
                      + user.getFistName()
                      + " "
                      + user.getLastName()
                      + " "
                      + user.getEmail());
            });
  }
}
