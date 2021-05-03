package com.forest.model.entity.nest;

import com.forest.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NestRepository extends JpaRepository<Nest, Long> {
    List<Nest> findAllByHabitId(Long habitId);
}
