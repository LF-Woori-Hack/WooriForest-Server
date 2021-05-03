package com.forest.model.entity.userSaveMoney;

import com.forest.model.entity.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@IdClass(UserSaveMoneyId.class)
public class UserSaveMoney {

    @Id
    private Long userId;

    @Id
    public Long saveMoneyId;

    @Builder
    public UserSaveMoney(Long userId, Long saveMoneyId) {
        this.userId = userId;
        this.saveMoneyId = saveMoneyId;
    }

    public UserSaveMoney() {
    }

}

