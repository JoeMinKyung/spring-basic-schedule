package com.example.basicschedule.service;

import com.example.basicschedule.dto.ScheduleRequestDto;
import com.example.basicschedule.dto.ScheduleResponseDto;
import com.example.basicschedule.entity.Schedule;
import com.example.basicschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto.getWriter(), dto.getDeadline(), dto.isCompleted(), dto.getTask());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getWriter(), savedSchedule.getCreatedAt(),
                savedSchedule.getUpdatedAt(), savedSchedule.getDeadline(), savedSchedule.isCompleted(), savedSchedule.getTask());

    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            ScheduleResponseDto dto = new ScheduleResponseDto(schedule.getId(), schedule.getWriter(), schedule.getCreatedAt(),
                    schedule.getUpdatedAt(), schedule.getDeadline(), schedule.isCompleted(), schedule.getTask());
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Schedule not found")
        );
        return new ScheduleResponseDto(schedule.getId(), schedule.getWriter(), schedule.getCreatedAt(),
                schedule.getUpdatedAt(), schedule.getDeadline(), schedule.isCompleted(), schedule.getTask());
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto dto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Schedule not found")
        );
        schedule.update(dto.getWriter(), dto.getDeadline(), dto.isCompleted(), dto.getTask());
        return new ScheduleResponseDto(schedule.getId(), schedule.getWriter(), schedule.getCreatedAt(),
                schedule.getUpdatedAt(), schedule.getDeadline(), schedule.isCompleted(), schedule.getTask());
    }

    @Transactional
    public void deleteById(Long id) {
        if(!scheduleRepository.existsById(id)) {
            throw new IllegalArgumentException("Schedule not found");
        }

        scheduleRepository.deleteById(id);
    }
}
