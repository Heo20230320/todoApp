package com.sparta.todoapp.dto;

import lombok.Getter;

import com.sparta.todoapp.entity.Comment;

@Getter
public class CommentResponseDto {
    private Long id;
    private String content;
    private String userId;
    private Long scheduleId;
    private String createdAt;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.userId = comment.getUserId();
        this.scheduleId = comment.getSchedule().getId();
        this.createdAt = comment.getCreatedAt().toString();
    }


}
