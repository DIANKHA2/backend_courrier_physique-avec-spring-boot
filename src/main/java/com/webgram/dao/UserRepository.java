package com.webgram.dao;

import com.webgram.entity.User;
import org.aspectj.weaver.patterns.IfPointcut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email); //vérification de l'@email et si l'utilisateur n'est pas supprimé
    boolean existsUserByEmailEqualsAndIsDeletedIsFalse(String Email);

}
