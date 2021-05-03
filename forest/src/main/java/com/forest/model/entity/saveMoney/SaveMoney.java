package com.forest.model.entity.saveMoney;

import com.forest.model.dto.request.ReqSavingJoinDto;
import com.forest.model.entity.nest.Nest;
import jdk.jfr.Timestamp;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class SaveMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "query")
    public String query;

    @Column(name = "comment")
    public String comment;

    @Column(name = "goal_amount")
    public Long goalAmount;

    @Column(name = "current_amount")
    public Long currentAmount;

    @Column(name = "monthly_payment")
    public Long monthlyPayment;

    @Column(name = "cheering_count")
    public Integer cheeringCount;


    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Timestamp
    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;


    @Builder
    private SaveMoney(ReqSavingJoinDto reqSavingJoinDto) {
        this.query = reqSavingJoinDto.query;
        this.goalAmount = reqSavingJoinDto.goalAmount;
        this.comment = reqSavingJoinDto.comment;
        this.monthlyPayment = Long.valueOf(200000);
        this.cheeringCount = 0;
        this.currentAmount = Long.valueOf(400000);
    }

    public SaveMoney() {

    }

    public static SaveMoney from(ReqSavingJoinDto reqSavingJoinDto) {
        return new SaveMoney(reqSavingJoinDto);
    }

}
