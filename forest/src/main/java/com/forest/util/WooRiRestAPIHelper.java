package com.forest.util;

import com.forest.model.dto.request.ReqWooriDto;
import com.forest.model.dto.response.ResLinkAccountDto;
import com.forest.model.dto.response.ResWooriDto;
import com.forest.model.entity.woori.APIType;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

public class WooRiRestAPIHelper {

    private final String appKey = "";
    private final String host  = "";

    public ResponseEntity<ResWooriDto> getAccTransList() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("appkey", this.appKey);
        headers.add("Content-Type", "application/json");

        URI url = URI.create(host+ APIType.AccTransList.getType());
        RequestEntity<ReqWooriDto> rq = new RequestEntity<>(headers, HttpMethod.POST, url);
        ResponseEntity<ResWooriDto> re = restTemplate.exchange(rq, ResWooriDto.class);
        return re;
    }

}
