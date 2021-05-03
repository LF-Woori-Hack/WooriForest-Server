package com.forest.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReqLoginDto {

    @NotNull
    public String deviceId;

    @NotNull
    public String snsToken;

    @NotNull
    public String snsType;

}
