package ningenme.net.sample.application.controller;

import lombok.RequiredArgsConstructor;
import ningenme.net.sample.infrastructure.mysql.UserMysqlRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final UserMysqlRepository userMysqlRepository;

    @GetMapping("/test1")
    public ResponseEntity<String> test1Get() {
        return ResponseEntity.ok("test1");
    }

    @GetMapping("/test2")
    public ResponseEntity<String> test2Get() {
        return ResponseEntity.ok("test2");
    }

    @GetMapping("/test3")
    public ResponseEntity<String> test3Get() {
        return ResponseEntity.ok("test3");
    }

    @GetMapping("/hoge")
    public ResponseEntity<Integer> hogeGet(
            @RequestParam("apiToken") String apiToken
    ) {
        return ResponseEntity.ok(userMysqlRepository.getUserModel(apiToken).getRoleModelList().size());
    }

}
