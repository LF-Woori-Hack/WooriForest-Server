package com.forest.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReqSavingJoinDto {

    @NotNull
    public String query;

    @NotNull
    public Long goalAmount;

    @NotNull
    public String comment;

}
