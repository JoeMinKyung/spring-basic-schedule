package com.example.basicschedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleRequestDto {
    private String writer;

    @JsonFormat(pattern = "yyyy-MM-dd") // 날짜 포멧 재한
    private LocalDate deadline;

    private String task;

    @JsonProperty("completed")  // JSON에서 "completed"로 전달된 값을 "isCompleted"로 매핑
    private boolean isCompleted;

}
