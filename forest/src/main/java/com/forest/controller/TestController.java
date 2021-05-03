package com.forest.controller;

import com.forest.service.TestService;
import com.forest.model.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/test")
public class TestController {
    private TestService testService;

//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUser(@PathVariable(value="id") String id) {
//        ResponseEntity<User> body = ResponseEntity.status(HttpStatus.OK).body(testService.getUser(Long.parseLong(id)));
//        return body;
//    }
//
//    @GetMapping("/temp")
//    public ResponseEntity<User> getDeviceId(@RequestParam Map<String, String> param) {
//        String strId = param.get("id");
//        ResponseEntity<User> body = ResponseEntity.status(HttpStatus.OK).body(testService.getUser(Long.parseLong(strId)));
//
//        return body;
//    }
}

