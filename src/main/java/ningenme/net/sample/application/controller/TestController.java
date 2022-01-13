package ningenme.net.sample.application.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.value.AuthorityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {

    @PreAuthorize("hasAuthority(AuthorityModel.TEST1.getAuthority())")
    @GetMapping("/test1")
    public ResponseEntity<String> test1Get() {
        log.info("test1 get");
        return ResponseEntity.ok("test1");
    }

    @GetMapping("/test2")
    public ResponseEntity<String> test2Get() {
        log.info("test2 get");
        return ResponseEntity.ok("test2");
    }

    @PreAuthorize("hasAuthority(AuthorityModel.TEST3.getAuthority())")
    @GetMapping("/test3")
    public ResponseEntity<String> test3Get() {
        log.info("test3 get");
        return ResponseEntity.ok("test3");
    }

}
