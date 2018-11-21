package kr.highthon.common.utils

import spock.lang.Specification

class StringUtilsTest extends Specification {

    def "repeat 5 times"() {
        expect:
        result == StringUtils.repeat(str, times)

        where:
        str  | times | result
        "s"  | 5     | "sssss"
        null | 5     | ""
    }
}
