package com.auth.user.web.service;

import com.auth.user.web.dto.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "auth-server",url = "localhost:8011")
public interface FeignCommunicator {

    @RequestMapping(
        method = RequestMethod.POST,
        value = "/auth/token")
    String createJwt(@RequestBody LoginRequest request);
}
