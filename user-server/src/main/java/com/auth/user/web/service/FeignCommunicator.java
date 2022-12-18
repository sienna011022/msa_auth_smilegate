package com.auth.user.web.service;

import com.auth.user.web.dto.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "auth-server",url = "localhost:8088")
public interface FeignCommunicator {

    @RequestMapping(
        method = RequestMethod.POST,
        value = "/auth/token")
    Map<String,String> createJwt(@RequestBody LoginRequest request);
}
