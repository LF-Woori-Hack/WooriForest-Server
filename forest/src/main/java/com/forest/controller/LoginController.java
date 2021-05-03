package com.forest.controller;

import com.forest.model.dto.request.ReqLoginDto;
import com.forest.model.dto.response.ResLoginDto;
import com.forest.model.entity.user.User;
import com.forest.model.entity.user.UserRepository;
import com.forest.service.LoginService;
import jdk.jfr.Timestamp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/login")
public class LoginController {

    private final LoginService service;

    @PostMapping
    public ResponseEntity<ResLoginDto> login(@RequestBody @Valid ReqLoginDto reqLoginDto) {
        String token = this.service.save(reqLoginDto);
        ResLoginDto resLoginDto = new ResLoginDto(true, token);
        ResponseEntity<ResLoginDto> body = ResponseEntity.status(HttpStatus.OK).body(resLoginDto);

        return body;
    }

    @GetMapping // Test
    public ResponseEntity<List<User>> getUser() {
        List<User> user = this.service.getUser();
        ResponseEntity<List<User>> body = ResponseEntity.status(HttpStatus.OK).body(user);
        return body;
    }

}