package com.sparta.todoapp.controller;

import com.sparta.todoapp.CommonResponse;
import com.sparta.todoapp.dto.DeleteScheduleRequestDto;
import com.sparta.todoapp.dto.ScheduleRequestDto;
import com.sparta.todoapp.dto.ScheduleResponseDto;
import com.sparta.todoapp.dto.UpdateScheduleRequestDto;
import com.sparta.todoapp.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@AllArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<CommonResponse<ScheduleResponseDto>> createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        ScheduleResponseDto schedule = scheduleService.createSchedule(scheduleRequestDto);
        return ResponseEntity.ok(
                CommonResponse.<ScheduleResponseDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .msg("생성이 완료 되었습니다.")
                        .data(schedule)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<ScheduleResponseDto>>> getAllSchedules() {
        List<ScheduleResponseDto> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok(
                CommonResponse.<List<ScheduleResponseDto>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .msg("목록 조회가 완료 되었습니다.")
                        .data(schedules)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<ScheduleResponseDto>> getSchedule(@PathVariable Long id) {
        ScheduleResponseDto schedule = scheduleService.getSchedule(id);
        return ResponseEntity.ok(
                CommonResponse.<ScheduleResponseDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .msg("단건 조회가 완료 되었습니다.")
                        .data(schedule)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse<ScheduleResponseDto>> updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleRequestDto updateScheduleRequestDto) {
        ScheduleResponseDto schedule = scheduleService.updateSchedule(id, updateScheduleRequestDto);
        return ResponseEntity.ok(
                CommonResponse.<ScheduleResponseDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .msg("수정이 완료 되었습니다.")
                        .data(schedule)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<Void>> deleteSchedule(@PathVariable Long id, @RequestBody DeleteScheduleRequestDto deleteScheduleRequestDto) {
        scheduleService.deleteSchedule(id, deleteScheduleRequestDto.getPassword());
        return ResponseEntity.ok(
                CommonResponse.<Void>builder()
                        .statusCode(HttpStatus.OK.value())
                        .msg("삭제가 완료 되었습니다.")
                        .build()
        );
    }
}

