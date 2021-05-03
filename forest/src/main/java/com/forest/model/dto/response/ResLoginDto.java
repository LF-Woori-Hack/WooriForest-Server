package com.forest.model.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResLoginDto {

    private Boolean success;
    private String token;

    @Builder
    public ResLoginDto(Boolean success, String token) {
        this.success = success;
        this.token = token;
    }

}
