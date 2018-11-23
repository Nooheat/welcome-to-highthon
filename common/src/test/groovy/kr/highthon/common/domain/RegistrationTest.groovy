package kr.highthon.common.domain

import spock.lang.Specification

import java.time.LocalDateTime

class RegistrationTest extends Specification {
    private Registration registration

    def setup() {
        registration = Registration.builder()
                .userId("user-id")
                .email("sample-email")
                .phoneNum("010-0000-1111")
                .name("윤찬명")
                .age(19)
                .build()
    }

    def '결제 확인시 결제 시간 또한 현재 시간으로 변경되어야한다.'() {

        given:
        def dateTimeBeforePay = LocalDateTime.now().minusSeconds(1)

        when:
        registration.pay()
        def payDate = registration.getPayDate()

        then:
        dateTimeBeforePay < payDate
        payDate < LocalDateTime.now().plusSeconds(1)
    }

}
