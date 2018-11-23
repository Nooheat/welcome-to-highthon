package kr.highthon.common.domain


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class RegistrationRepositoryTest extends Specification {

    @Autowired
    private RegistrationRepository registrationRepository;

    def "RegistrationRepository - 저장 테스트"() {
        def registration = Registration.builder()
                .userId("user-id")
                .email("sample-email")
                .phoneNum("010-0000-1111")
                .name("윤찬명")
                .age(19)
                .build()
        when:
        registrationRepository.save(registration)

        then:
        registrationRepository.count() == 1
    }
}
