package com.example.basicschedule.dto;

import com.example.basicschedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String writer;
    private final LocalDate createdAt;
    private final LocalDate updatedAt;
    private final LocalDate deadline;
    private final boolean isCompleted;
    private final String task;

    public ScheduleResponseDto(Long id, String writer, LocalDate createdAt, LocalDate updatedAt, LocalDate deadline, boolean isCompleted, String task) {
        this.id = id;
        this.writer = writer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deadline = deadline;
        this.isCompleted = isCompleted;
        this.task = task;
    }
}
