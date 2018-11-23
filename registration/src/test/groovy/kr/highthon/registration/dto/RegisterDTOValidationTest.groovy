package kr.highthon.registration.dto

class RegisterDTOValidationTest extends ValidationTest {

    private static final String NAME = "윤찬명"
    private static final String EMAIL = "nooheat1228@gmail.com"
    private static final String PHONE_NUM = "010-0000-0000"
    private static final Integer AGE = 19

    def '이름은 null또는 공백이 될 수 없다.'() {
        expect:
        violations == validate(name, EMAIL, PHONE_NUM, AGE)

        where:
        name  | violations
        null  | 1
        ""    | 1
        "윤찬명" | 0
    }

    def '이메일은 형식이 맞는 문자열이어야하고, null 또는 공백이 될 수 없다.'() {
        expect:
        violations == validate(NAME, email, PHONE_NUM, AGE)

        where:
        email                   | violations
        null                    | 1
        ""                      | 1
        "not an email format"   | 1
        "nooheat1228@gmail.com" | 0
    }

    def '전화번호는 000-0000-0000 형식이어야하고, null 또는 공백이 될 수 없다.'() {
        expect:
        violations == validate(NAME, EMAIL, phoneNum, AGE)

        where:
        phoneNum        | violations
        null            | 1
        ""              | 1
        "an string"     | 1
        "01000000000"   | 1
        "010-0000-0000" | 0
    }

    def '연령은 14세 이상 20세 이하여야한다. null이 될 수 없다.'() {
        expect:
        violations == validate(NAME, EMAIL, PHONE_NUM, age)


        where:
        age  | violations
        null | 1
        13   | 1
        14   | 0
        20   | 0
        21   | 1
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
