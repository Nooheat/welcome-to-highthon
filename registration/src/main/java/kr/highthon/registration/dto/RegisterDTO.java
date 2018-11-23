package kr.highthon.registration.dto;


import kr.highthon.common.domain.Registration;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
public class RegisterDTO {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotNull
    @Pattern(regexp = "^01([0|1|6|7|8|9]?)-([0-9]{3,4})-([0-9]{4})$")
    private String phoneNum;

    @NotNull
    @Range(min = 14, max = 20)
    private Integer age;

    @Builder
    public RegisterDTO(String name, String email, String phoneNum, Integer age) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.age = age;
    }

    public Registration toEntity() {
        return Registration.builder()
                .name(name)
                .email(email)
                .phoneNum(phoneNum)
                .age(age)
                .build();
    }
}
