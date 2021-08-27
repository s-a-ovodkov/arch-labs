package ru.otus.ovodkov.task02.mappers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.ovodkov.task02.datahelper.UserDataHelper;
import ru.otus.ovodkov.task02.dto.UserProfile;
import ru.otus.ovodkov.task02.models.User;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** @author Ovodkov Sergey created on 26.07.2021 */
@SpringBootTest
@DisplayName("Проверка работы UserMapper")
class UserMapperTest {

  @Autowired private UserMapper mapper;
  @Autowired private UserDataHelper dataHelper;

  @Test
  @DisplayName("Коректное преобразование из User в UserProfile")
  void givenUserToUserProfile_whenMaps_thenCorrect() {
    User user = dataHelper.createUser();

    UserProfile userProfile = mapper.userToUserProfile(user);

    assertAll(
        () -> assertEquals(UserDataHelper.USER_ID, userProfile.getId()),
        () -> assertEquals(UserDataHelper.USERNAME, userProfile.getUsername()),
        () -> assertEquals(UserDataHelper.FIRSTNAME, userProfile.getFirstName()),
        () -> assertEquals(UserDataHelper.LASTNAME, userProfile.getLastName()),
        () -> assertEquals(UserDataHelper.EMAIL, userProfile.getEmail()),
        () -> assertEquals(UserDataHelper.PHONE, userProfile.getPhone()));
  }

  @Test
  @DisplayName("Коректное преобразование из UserProfile в User")
  void giveUserProfileToUser_whenMaps_thenCorrect() {
    UserProfile userProfile = new UserProfile();
    userProfile.setId(UserDataHelper.USER_ID);
    userProfile.setUsername(UserDataHelper.USERNAME);
    userProfile.setFirstName(UserDataHelper.FIRSTNAME);
    userProfile.setLastName(UserDataHelper.LASTNAME);
    userProfile.setEmail(UserDataHelper.EMAIL);
    userProfile.setPhone(UserDataHelper.PHONE);

    User user = mapper.userProfileToUser(userProfile);

    assertAll(
        () -> assertEquals(UserDataHelper.USER_ID, user.getId()),
        () -> assertEquals(UserDataHelper.USERNAME, user.getUsername()),
        () -> assertEquals(UserDataHelper.FIRSTNAME, user.getFirstName()),
        () -> assertEquals(UserDataHelper.LASTNAME, user.getLastName()),
        () -> assertEquals(UserDataHelper.EMAIL, user.getEmail()),
        () -> assertEquals(UserDataHelper.PHONE, user.getPhone()));
  }
}
