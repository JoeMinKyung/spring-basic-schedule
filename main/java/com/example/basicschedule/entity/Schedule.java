package com.example.basicschedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) // 자동 날짜 업데이트 활성화
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writer;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDate deadline;

    private boolean isCompleted;

    private String task;

    public Schedule(String writer, LocalDate deadline, boolean isCompleted, String task) {
        this.writer = writer;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.deadline = deadline;
        this.isCompleted = isCompleted;
        this.task = task;
    }

    public void update(String writer, LocalDate deadline, boolean isCompleted, String task) {
        this.writer = writer;
        this.deadline = deadline;
        this.isCompleted = isCompleted;
        this.task = task;
        this.updatedAt = LocalDateTime.now();
    }
}
