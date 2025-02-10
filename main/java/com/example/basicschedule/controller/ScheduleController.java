package com.example.basicschedule.controller;

import com.example.basicschedule.dto.ScheduleRequestDto;
import com.example.basicschedule.dto.ScheduleResponseDto;
import com.example.basicschedule.repository.ScheduleRepository;
import com.example.basicschedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    @PostMapping
    public ScheduleResponseDto save(@RequestBody ScheduleRequestDto dto){
        return scheduleService.save(dto);
    }

    @GetMapping
    public List<ScheduleResponseDto> findAll(){
        return scheduleService.findAll();
    }

    @GetMapping("/{id}")
    public ScheduleResponseDto findById(@PathVariable Long id){
        return scheduleService.findById(id);
    }

    @PutMapping("/{id}")
    public ScheduleResponseDto update(@PathVariable Long id, @RequestBody ScheduleRequestDto dto){
        return scheduleService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        scheduleRepository.deleteById(id);
    }
}
