package kr.highthon.registration.dto

class RegisterDTOValidationTest extends ValidationTest {

    private static final String NAME = "윤찬명"
    private static final String EMAIL = "nooheat1228@gmail.com"
    private static final String PHONE_NUM = "010-0000-0000"
    private static final Integer AGE = 19

    def '이름은 null또는 공백이 될 수 없다.'() {
        expect:
        passed == (validate(name, EMAIL, PHONE_NUM, AGE) == 0)

        where:
        name  | passed
        null  | false
        ""    | false
        "윤찬명" | true
    }

    def '이메일은 형식이 맞는 문자열이어야하고, null 또는 공백이 될 수 없다.'() {
        expect:
        passed == (validate(NAME, email, PHONE_NUM, AGE) == 0)

        where:
        email                   | passed
        null                    | false
        ""                      | false
        "not an email format"   | false
        "nooheat1228@gmail.com" | true
    }

    def '전화번호는 000-0000-0000 형식이어야하고, null 또는 공백이 될 수 없다.'() {
        expect:
        passed == (validate(NAME, EMAIL, phoneNum, AGE) == 0)

        where:
        phoneNum        | passed
        null            | false
        ""              | false
        "an string"     | false
        "01000000000"   | false
        "010-0000-0000" | true
    }

    def '연령은 14세 이상 20세 이하여야한다. null이 될 수 없다.'() {
        expect:
        passed == (validate(NAME, EMAIL, PHONE_NUM, age) == 0)


        where:
        age  | passed
        null | false
        13   | false
        14   | true
        20   | true
        21   | false
    }

    def 'toEntity()는 Registration과 1대1로 완전히 변환되어야한다.'() {
        given:
        def registerDTO = new RegisterDTO(NAME, EMAIL, PHONE_NUM, AGE)

        when:
        def registration = registerDTO.toEntity()

        then:
        registration.getName() == NAME
        registration.getEmail() == EMAIL
        registration.getPhoneNum() == PHONE_NUM
        registration.getAge() == AGE
    }

    private int validate(String name, String email, String phoneNum, Integer age) {
        return validate(new RegisterDTO(name, email, phoneNum, age))
    }
}
