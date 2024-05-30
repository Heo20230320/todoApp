package com.sparta.todoapp.dto;

import com.sparta.todoapp.entity.Schedule;
import lombok.Getter;

@Getter

public class ScheduleResponseDto {
    private Long id;

    private String title;

    private String contents;

    private String manager;

    private String date;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.manager = schedule.getManager();
        this.date = schedule.getDate();

    }
}
