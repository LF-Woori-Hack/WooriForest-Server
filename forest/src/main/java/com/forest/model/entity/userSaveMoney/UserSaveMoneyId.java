package com.forest.model.entity.userSaveMoney;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserSaveMoneyId implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    private Long userId;

    @EqualsAndHashCode.Include
    @Id
    public Long saveMoneyId;

    @Builder
    public UserSaveMoneyId(Long userId, Long saveMoneyId) {
        this.userId = userId;
        this.saveMoneyId = saveMoneyId;
    }

    public UserSaveMoneyId() {
    }

}