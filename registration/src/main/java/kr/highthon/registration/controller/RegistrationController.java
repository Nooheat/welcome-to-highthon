package kr.highthon.registration.controller;

import kr.highthon.common.api.ApiResponse;
import kr.highthon.common.domain.Registration;
import kr.highthon.common.domain.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/registrations")
public class RegistrationController {

    private RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public ApiResponse<Registration> register(@Valid @RequestBody Registration registration) {
        return ApiResponse.success(registrationRepository.save(registration));
    }
}
