package kr.highthon.backoffice.sample

import spock.lang.Specification

class SampleTest extends Specification {

    def "샘플 테스트"() {
        expect:
        c == a + b

        where:
        c | a | b
        3 | 1 | 2
    }
}
