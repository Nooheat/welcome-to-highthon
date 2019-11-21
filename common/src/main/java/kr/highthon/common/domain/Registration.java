package kr.highthon.common.domain;

import kr.highthon.common.exception.AlreadyPaidException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 60, nullable = false, unique = true)
    private String email;

    @Column(length = 15, nullable = false, unique = true)
    private String phoneNum;

    @Column(nullable = false)
    private Boolean paid;

    @Column(insertable = false)
    private LocalDateTime payDate;

    @Column(nullable = false)
    private Integer age;

    @Builder
    private Registration(String name, String email, String phoneNum, Integer age) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.age = age;
        this.paid = false;
    }

    public void pay() {
        if (this.paid) throw new AlreadyPaidException();
        this.paid = true;
        this.payDate = LocalDateTime.now();
    }
}
