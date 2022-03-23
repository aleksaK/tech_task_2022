package lv.kalashnikov.insurance.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping(path = "/", produces = "application/json")
    public String healthCheck() {
        return "OK";
    }

}