package com.forest.controller;

import com.forest.model.dto.response.ResLoginDto;
import com.forest.model.dto.response.ResNestDetailDto;
import com.forest.model.dto.response.ResSuccessDto;
import com.forest.model.entity.nest.Nest;
import com.forest.service.NestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/nest")
public class NestController {

    private final NestService nestService;

    @GetMapping("/detail")
    public ResponseEntity<List<ResNestDetailDto>> getDetailList(@RequestHeader("Authorization") String token,
                                                                @RequestParam Map<String, String> param) {
        String strId = param.get("id");
        List<ResNestDetailDto> resNestDetailDtoList = this.nestService.getNestList(Long.parseLong(strId));
        ResponseEntity<List<ResNestDetailDto>> body = ResponseEntity.status(HttpStatus.OK).body(resNestDetailDtoList);
        return body;
    }

    @GetMapping("/join")
    public ResponseEntity<ResSuccessDto> join(@RequestHeader("Authorization") String token,
                                              @RequestParam Map<String, String> param) {
        String strId = param.get("id");
        this.nestService.join(Long.parseLong(strId), token);
        ResponseEntity<ResSuccessDto> body = ResponseEntity.status(HttpStatus.OK).body(new ResSuccessDto(true));
        return body;
    }

}
