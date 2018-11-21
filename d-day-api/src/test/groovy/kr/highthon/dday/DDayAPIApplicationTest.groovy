package kr.highthon.dday

import spock.lang.Specification

class DDayAPIApplicationTest extends Specification {

    def "DDay - 샘플 테스트"() {
        expect:
        c == a + b

        where:
        c | a | b
        3 | 1 | 2
    }
}
