package com.example.basicschedule.dto;

import com.example.basicschedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String writer;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final LocalDate deadline;
    private final boolean isCompleted;
    private final String task;

    public ScheduleResponseDto(Long id, String writer, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDate deadline, boolean isCompleted, String task) {
        this.id = id;
        this.writer = writer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deadline = deadline;
        this.isCompleted = isCompleted;
        this.task = task;
    }
}
