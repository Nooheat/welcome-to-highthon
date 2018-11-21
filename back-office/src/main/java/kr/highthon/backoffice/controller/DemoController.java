package kr.highthon.backoffice.controller;

import kr.highthon.common.domain.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public Registration getAnyRegistration() {
        return Registration.builder()
                .userId("Hello It's BackOffice demo registration object")
                .build();
    }

}
