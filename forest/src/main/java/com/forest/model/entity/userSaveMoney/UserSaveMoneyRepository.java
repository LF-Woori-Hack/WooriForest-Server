package com.forest.model.entity.userSaveMoney;

import com.forest.model.entity.saveMoney.SaveMoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSaveMoneyRepository  extends JpaRepository<UserSaveMoney, Long> {
    UserSaveMoney findByUserId(Long id);
}
