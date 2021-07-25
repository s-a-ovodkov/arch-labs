package ru.otus.ovodkov.task02.mappers;

import org.mapstruct.Mapper;
import ru.otus.ovodkov.task02.dto.UserProfile;
import ru.otus.ovodkov.task02.models.User;

/** @author Ovodkov Sergey created on 22.07.2021 */
@Mapper(componentModel = "spring")
public interface UserMapper {

  UserProfile userToUserProfile(User user);

  User userProfileToUser(UserProfile userProfile);
}
