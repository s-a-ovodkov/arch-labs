package ru.otus.ovodkov.task02.services;

import ru.otus.ovodkov.task02.dto.UserProfile;

/**
 * Сервис для работы с даннми пользователя
 *
 * @author Ovodkov Sergey created on 22.07.2021
 */
public interface UserService {

  /**
   * Найти пользователя по указанному идентификатору
   *
   * @param id идентификатор искомого пользователя
   * @return данные искомого пользователя
   */
  UserProfile getUser(Long id);

  /**
   * Создать нового пользователя
   *
   * @param userProfile данные нового пользователя
   * @return идентификатор созданного пользователя
   */
  Long createUser(UserProfile userProfile);

  /**
   * Обновить данные указанного пользователя
   *
   * @param user обновленные данные пользователя
   */
  void updateUser(UserProfile user);

  /**
   * Удалить данные пользователя
   *
   * @param id иденнтификатор удаляемого пользователя
   */
  void deleteUser(Long id);
}
