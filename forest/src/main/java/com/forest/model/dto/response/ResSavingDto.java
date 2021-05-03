package com.forest.model.dto.response;

import com.forest.model.entity.saveMoney.SaveMoney;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResSavingDto {

    private String query;
    private Long goalAmount;
    private String comment;
    private Long currentAmount;
    private Long monthlyPayment;
    private Integer cheeringCount;

    @Builder
    public ResSavingDto(SaveMoney saveMoney) {
        this.query = saveMoney.query;
        this.goalAmount = saveMoney.goalAmount;
        this.comment = saveMoney.comment;
        this.currentAmount = saveMoney.currentAmount;
        this.monthlyPayment = saveMoney.monthlyPayment;
        this.cheeringCount = saveMoney.cheeringCount;
    }

    @Builder
    public ResSavingDto() {

    }

}
