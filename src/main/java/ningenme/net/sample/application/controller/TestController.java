package ningenme.net.sample.application.controller;

import lombok.RequiredArgsConstructor;
import ningenme.net.sample.infrastructure.mysql.ApiUserMysqlRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    @PreAuthorize("hasAuthority('test1')")
    @GetMapping("/test1")
    public ResponseEntity<String> test1Get() {
        return ResponseEntity.ok("test1");
    }

    @GetMapping("/test2")
    public ResponseEntity<String> test2Get() {
        return ResponseEntity.ok("test2");
    }

    @PreAuthorize("hasAuthority('test3')")
    @GetMapping("/test3")
    public ResponseEntity<String> test3Get() {
        return ResponseEntity.ok("test3");
    }

}
