package com.sw9.swe.controller.schedule;

import com.sw9.swe.config.security.PrincipalDetails;
import com.sw9.swe.controller.response.Response;
import com.sw9.swe.service.schedule.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import static com.sw9.swe.controller.response.Response.success;

@RequiredArgsConstructor
@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping("/api/schedule")
    @ResponseStatus(HttpStatus.OK)
    public Response read(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        return success(scheduleService.read(principalDetails));
    }
}
