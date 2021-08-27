package ru.otus.ovodkov.task02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.task02.models.User;

/**
 * Репозиторий для работы с даннми пользователей
 *
 * @author Ovodkov Sergey created on 22.07.2021
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
