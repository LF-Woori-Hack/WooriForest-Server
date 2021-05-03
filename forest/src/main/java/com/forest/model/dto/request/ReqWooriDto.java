package com.forest.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReqWooriDto {
    ReqWooriHeaderDto dataHeader = new ReqWooriHeaderDto();
    ReqWooriBodyDto dataBodyDto = new ReqWooriBodyDto();
}
