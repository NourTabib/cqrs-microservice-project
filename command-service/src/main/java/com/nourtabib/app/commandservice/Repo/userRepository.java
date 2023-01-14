package com.nourtabib.app.commandservice.Repo;

import com.nourtabib.app.commandservice.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<UserEntity,Long> {
}
