package com.forest.model.entity.habit;

import jdk.jfr.Timestamp;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "member_count")
    public Integer memberCount;

    @Column(name = "title", unique = true)
    public String title;

    @Column(name = "content")
    public String content;

    @Column(name = "owner_id", unique = true)
    private Long ownerId;


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
    public Habit() {

    }

    public static Habit from() {
        return new Habit();
    }

}
