package com.forest.model.dto.response;

import com.forest.model.entity.nest.Nest;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResNestDetailDto {

    private Long id;
    private String title;
    private String content;
    private Integer memberCount;

    @Builder
    private ResNestDetailDto(Long id, String title, String content, Integer memberCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberCount = memberCount;
    }

    @Builder
    public ResNestDetailDto(Nest nest) {
        this.id = nest.id;
        this.title = nest.title;
        this.content = nest.content;
        this.memberCount = nest.memberCount;
    }

}
