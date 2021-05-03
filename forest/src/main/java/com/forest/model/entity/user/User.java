package com.forest.model.entity.user;

import com.forest.model.dto.request.ReqLinkAccountDto;
import com.forest.model.dto.request.ReqLoginDto;
import com.forest.model.entity.saveMoney.SaveMoney;
import jdk.jfr.Timestamp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "sns_token", unique = true)
    public String snsToken;

    @Column(name = "profile_image", unique = true)
    public String profileImage;

    @Column(name = "sns_type")
    public String snsType;

    @Column(name = "device_id", unique = true)
    public String deviceId;

    @Column(name = "token", unique = true)
    public String token;

    @Column(name = "habit_id")
    public Long habitId;

    @Column(name = "nest_id")
    public Long nestId;

    @Column(name = "account", unique = true)
    public String account;

    @Column(name = "phone_number", unique = true)
    public String phoneNumber;

    @Column(name = "name")
    public String name;

    @Column(name = "carrier")
    public Integer carrier;

    @Column(name = "birthday")
    public String birthday;

    @Column(name = "rrno")
    public String rrno;


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
    public User() {

    }

    @Builder
    public User(Integer carrier, String phoneNumber, String name, String birthday, String rrno) {
        this.carrier = carrier;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.birthday = birthday;
        this.rrno = rrno;
    }

    @Builder
    public User(ReqLoginDto reqLoginDto, String token) {
        this.deviceId = reqLoginDto.deviceId;
        this.snsToken = reqLoginDto.snsToken;
        this.snsType = reqLoginDto.snsType;
        this.token = token;
    }

    @Builder
    public User(User user, ReqLinkAccountDto reqLinkAccountDto) {
        this.id = user.id;
        this.deviceId = user.deviceId;
        this.snsToken = user.snsToken;
        this.snsType = user.snsType;
        this.token = user.token;
        this.carrier = reqLinkAccountDto.carrier;
        this.phoneNumber = reqLinkAccountDto.phone;
        this.name = reqLinkAccountDto.name;
        this.birthday = reqLinkAccountDto.birthday;
        this.rrno = reqLinkAccountDto.rrno;
    }

    @Builder
    public User(User user, Long habitId, Long nestId) {
        this.id = user.id;
        this.deviceId = user.deviceId;
        this.snsToken = user.snsToken;
        this.snsType = user.snsType;
        this.token = user.token;
        this.carrier = user.carrier;
        this.phoneNumber = user.phoneNumber;
        this.name = user.name;
        this.birthday = user.birthday;
        this.rrno = user.rrno;
        this.habitId = habitId;
        this.nestId = nestId;
    }

    public static User from(ReqLoginDto reqLoginDto, String token) {
        return new User(reqLoginDto, token);
    }

    public static User from(User uesr, ReqLinkAccountDto reqLinkAccountDto) {
        return new User(uesr, reqLinkAccountDto);
    }

    public static User from(User uesr, Long habitId, Long nestId) {
        return new User(uesr, habitId, nestId);
    }

}
