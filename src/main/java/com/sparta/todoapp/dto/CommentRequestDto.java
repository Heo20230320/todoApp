package com.sparta.todoapp.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private String content;
    private String userId;
    private Long scheduleId;


}
