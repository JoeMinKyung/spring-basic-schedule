package com.example.basicschedule.service;

import com.example.basicschedule.dto.ScheduleRequestDto;
import com.example.basicschedule.dto.ScheduleResponseDto;
import com.example.basicschedule.entity.Schedule;
import com.example.basicschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SchduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleRequestDto save(ScheduleResponseDto dto) {
        Schedule schedule = new Schedule(dto.getWriter(), dto.getDeadline(), dto.getTask());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleRequestDto(savedSchedule.getId(), savedSchedule.getWriter(), savedSchedule.getCreatedAt(),
                savedSchedule.getUpdatedAt(), savedSchedule.getDeadline(), savedSchedule.isCompleted(), savedSchedule.getTask());

    }
}
