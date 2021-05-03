package com.forest.model.dto.response;

import com.forest.model.entity.habit.Habit;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResLinkAccountDto {

    private Long id;
    private String title;
    private String content;
    private Integer memberCount;

    @Builder
    private ResLinkAccountDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberCount = 0;
    }

    @Builder
    public ResLinkAccountDto(Habit habit) {
        this.id = habit.id;
        this.title = habit.title;
        this.content = habit.content;
        this.memberCount = habit.memberCount;
    }
}
