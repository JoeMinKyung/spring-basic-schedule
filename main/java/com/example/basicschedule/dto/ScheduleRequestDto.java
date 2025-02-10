package com.example.basicschedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class ScheduleRequestDto {
    private String writer;

    @JsonFormat(pattern = "yyyy-MM-dd") // 날짜 포멧 재한
    private LocalDate deadline;

    private String task;

    @Setter
    private boolean isCompleted;

}
