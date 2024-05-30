package com.sparta.todoapp.dto;

import lombok.Getter;

@Getter

public class UpdateScheduleRequestDto {
    private String title;
    private String contents;
    private String manager;
    private String password;
    private String date;
}
