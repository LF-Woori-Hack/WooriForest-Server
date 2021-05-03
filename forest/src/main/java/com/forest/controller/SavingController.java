package com.forest.controller;

import com.forest.model.dto.request.ReqLoginDto;
import com.forest.model.dto.request.ReqSavingJoinDto;
import com.forest.model.dto.response.ResLoginDto;
import com.forest.model.dto.response.ResSavingDto;
import com.forest.model.dto.response.ResSuccessDto;
import com.forest.service.LoginService;
import com.forest.service.SavingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/saving")
public class SavingController {

    private final SavingService service;

    @PostMapping("/join")
    public ResponseEntity<ResSuccessDto> join(@RequestHeader("Authorization") String token,
                                              @RequestBody @Valid ReqSavingJoinDto reqSavingJoinDto) {
        this.service.save(reqSavingJoinDto, token);
        ResSuccessDto resSuccessDto = new ResSuccessDto(true);
        ResponseEntity<ResSuccessDto> body = ResponseEntity.status(HttpStatus.OK).body(resSuccessDto);
        return body;
    }

    @GetMapping
    public ResponseEntity<ResSavingDto> getSavingData(@RequestHeader("Authorization") String token) {
        ResSavingDto resSavingDto = this.service.getSaveMoney(token);
        ResponseEntity<ResSavingDto> body = ResponseEntity.status(HttpStatus.OK).body(resSavingDto);
        return body;
    }

}