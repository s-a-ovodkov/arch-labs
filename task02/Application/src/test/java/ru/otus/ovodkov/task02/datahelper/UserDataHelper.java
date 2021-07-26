package ru.otus.ovodkov.task02.datahelper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.ovodkov.task02.models.User;
import ru.otus.ovodkov.task02.repositories.UserRepository;

/**
 * @author Ovodkov Sergey
 * created on 26.07.2021
 */
@RequiredArgsConstructor
@Component
public class UserDataHelper {

  private final UserRepository userRepository;

  public static final Long USER_ID = 1L;
  public static final String USERNAME = "username";
  public static final String FIRSTNAME = "Roy";
  public static final String LASTNAME = "Osherove";
  public static final String EMAIL = "test@mail.qa";
  public static final String PHONE = "+79001112233";

  public User createUser() {
    User user = new User();
    user.setId(USER_ID);
    user.setUsername(USERNAME);
    user.setFirstName(FIRSTNAME);
    user.setLastName(LASTNAME);
    user.setEmail(EMAIL);
    user.setPhone(PHONE);
    return user;
  }

  public void createAndSave() {
    User user = createUser();
    userRepository.save(user);
  }
}
