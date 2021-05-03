package com.forest.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReqLinkAccountDto {

    @NotNull
    public Integer carrier;

    @NotNull
    public String phone;

    @NotNull
    public String name;

    @NotNull
    public String birthday;

    @NotNull
    public String rrno;

}
