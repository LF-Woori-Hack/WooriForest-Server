package com.forest.controller;

import com.forest.model.dto.request.ReqLinkAccountDto;
import com.forest.model.dto.request.ReqLoginDto;
import com.forest.model.dto.response.ResLinkAccountDto;
import com.forest.model.dto.response.ResLoginDto;
import com.forest.model.entity.habit.Habit;
import com.forest.model.entity.user.User;
import com.forest.service.LinkAccountService;
import com.forest.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/linkTrans")
public class LinkAccountController {

    private final LinkAccountService service;

    @PostMapping
    public ResponseEntity<List<ResLinkAccountDto>> link(@RequestHeader("Authorization") String token,
                                                        @RequestBody @Valid ReqLinkAccountDto reqLinkAccountDto) {
        List<ResLinkAccountDto> habitList = this.service.save(reqLinkAccountDto, token);
        ResponseEntity<List<ResLinkAccountDto>> body = ResponseEntity.status(HttpStatus.OK).body(habitList);
        return body;
    }

}
