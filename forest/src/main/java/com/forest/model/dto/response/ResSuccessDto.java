package com.forest.model.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResSuccessDto {

    private Boolean success;

    @Builder
    public ResSuccessDto(Boolean success) {
        this.success = success;
    }

}
