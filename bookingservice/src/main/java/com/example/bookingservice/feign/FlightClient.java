package com.example.bookingservice.feign;

import com.example.bookingservice.dto.FlightDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FLIGHT-SERVICE")
public interface FlightClient {
    @GetMapping("/flights/{id}")
    FlightDTO getFlightById(@PathVariable Long id);
}
