package kr.highthon.common.domain

import spock.lang.Specification

class RegistrationTest extends Specification {

    def "Registration - userId나 email이 null일 수 없다."() {
        when:
        Registration.builder()
                .phoneNum("010-0000-1111")
                .name("윤찬명")
                .paid(false)
                .build()

        then:
        thrown IllegalArgumentException
    }
}
