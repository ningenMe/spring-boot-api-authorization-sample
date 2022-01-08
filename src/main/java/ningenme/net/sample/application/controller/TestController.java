package ningenme.net.sample.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test1")
    public ResponseEntity<String> test1Get() {
        return ResponseEntity.ok("test1");
    }

}
