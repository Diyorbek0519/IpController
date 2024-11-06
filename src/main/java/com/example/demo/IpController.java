package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class IpController {

    @GetMapping("/client-info")
    public ResponseEntity<String> getClientInfo(HttpServletRequest request) {
        String clientIp = request.getHeader("X-Forwarded-For");
        if (clientIp == null || clientIp.isEmpty()) {
            // If no X-Forwarded-For header, fall back to getRemoteAddr()
            clientIp = request.getRemoteAddr();
        }
        // Get the client port
        int clientPort = request.getRemotePort();
        return ResponseEntity.ok(String.format("Client IP: %s, Client Port: %d", clientIp, clientPort));
    }
}
