package ru.otus.ovodkov.task02.datahelper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.ovodkov.task02.dto.UserProfile;
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
    User user = creatingUserWithoutId();
    user.setId(USER_ID);
    return user;
  }

  public UserProfile createUserProfile() {
    UserProfile userProfile = new UserProfile();
    userProfile.setUsername(USERNAME);
    userProfile.setFirstName(FIRSTNAME);
    userProfile.setLastName(LASTNAME);
    userProfile.setEmail(EMAIL);
    userProfile.setPhone(PHONE);
    return userProfile;
  }

  public Long createAndSave() {
    User user = creatingUserWithoutId();
    userRepository.save(user);
    return user.getId();
  }

  public void deleteUsers() {
    userRepository.deleteAll();
    userRepository.flush();
  }

  private User creatingUserWithoutId() {
    User user = new User();
    user.setUsername(USERNAME);
    user.setFirstName(FIRSTNAME);
    user.setLastName(LASTNAME);
    user.setEmail(EMAIL);
    user.setPhone(PHONE);
    return user;
  }
}
