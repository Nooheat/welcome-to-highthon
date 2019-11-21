package kr.highthon.dday.controller;

import kr.highthon.common.domain.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DDayDemoController {

    @GetMapping("/")
    public Registration getAnyRegistration() {
        return Registration.builder()
                .build();
    }
}
