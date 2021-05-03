package com.forest.model.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByToken(String token);

    Optional<User> findByDeviceId(String deviceId);

}
