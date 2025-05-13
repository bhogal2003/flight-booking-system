package com.example.bookingservice.feign;

import com.example.bookingservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {
    @GetMapping("/users/{username}")
    UserDTO getUserByUsername(@PathVariable String username);
}
