package kr.highthon.common.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Registration {

    @Id
    private String userId;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 60, nullable = false, unique = true)
    private String email;

    @Column(length = 15, nullable = false, unique = true)
    private String phoneNum;

    @Column(nullable = false)
    private Boolean paid;

    @Builder
    public Registration(String userId, String name, String email, String phoneNum, Boolean paid) {
        if (userId == null || email == null) {
            throw new IllegalArgumentException("userId나 email은 null이 될 수 없습니다.");
        }
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.paid = paid;
    }
}
