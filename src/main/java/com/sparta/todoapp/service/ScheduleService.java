package com.sparta.todoapp.service;

import com.sparta.todoapp.dto.ScheduleRequestDto;
import com.sparta.todoapp.dto.ScheduleResponseDto;
import com.sparta.todoapp.dto.UpdateScheduleRequestDto;
import com.sparta.todoapp.entity.Schedule;
import com.sparta.todoapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule(scheduleRequestDto);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule);
    }

    public List<ScheduleResponseDto> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream()
                .map(ScheduleResponseDto::new)
                .collect(Collectors.toList());
    }

    public ScheduleResponseDto getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정이 존재하지 않습니다"));
        return new ScheduleResponseDto(schedule);
    }

    public ScheduleResponseDto updateSchedule(Long id, UpdateScheduleRequestDto updateScheduleRequestDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정이 존재하지 않습니다"));

        if (!Objects.equals(updateScheduleRequestDto.getPassword(), schedule.getPassword())) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }

        schedule.setTitle(updateScheduleRequestDto.getTitle());
        schedule.setContents(updateScheduleRequestDto.getContents());
        schedule.setManager(updateScheduleRequestDto.getManager());
        schedule.setDate(updateScheduleRequestDto.getDate());
        Schedule updatedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(updatedSchedule);
    }

    public void deleteSchedule(Long id, String password) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정이 존재하지 않습니다"));

        if (!Objects.equals(password, schedule.getPassword())) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }

        scheduleRepository.delete(schedule);
    }
}