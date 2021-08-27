package ru.otus.ovodkov.task02.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ovodkov.task02.dto.UserProfile;
import ru.otus.ovodkov.task02.exceptions.NoEntityException;
import ru.otus.ovodkov.task02.mappers.UserMapper;
import ru.otus.ovodkov.task02.models.User;
import ru.otus.ovodkov.task02.repositories.UserRepository;

/**
 * Сервсир работы с даннми пользователя
 *
 * @author Ovodkov Sergey created on 22.07.2021
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository repository;
  private final UserMapper mapper;

  /** {@inheritDoc} */
  @Override
  @Transactional(readOnly = true)
  public UserProfile getUser(Long id) {
    User user =
        repository
            .findById(id)
            .orElseThrow(() -> new NoEntityException(User.class.getName(), "id", id.toString()));
    return mapper.userToUserProfile(user);
  }

  /** {@inheritDoc} */
  @Override
  @Transactional
  public Long createUser(UserProfile userProfile) {
    User user = mapper.userProfileToUser(userProfile);
    return repository.saveAndFlush(user).getId();
  }

  /** {@inheritDoc} */
  @Override
  @Transactional
  public void updateUser(UserProfile userProfile) {
    User user = mapper.userProfileToUser(userProfile);
    repository.saveAndFlush(user);
  }

  /** {@inheritDoc} */
  @Override
  @Transactional
  public void deleteUser(Long id) {
    repository.deleteById(id);
  }
}
