package com.mavendemo

import spock.lang.Specification

class MathUtilSpockTest extends Specification {
    def "SumBiggestPair"(int a, int b, int c) {
        expect:
        MathUtil.sumBiggestPair(a, b, c) == expectedResult

        where:
        a | b | c | expectedResult
        5 | 2 | 3 | 8
        5 | 4 | 1 | 9
        3 | 2 | 6 | 8
        2 | 2 | 2 | 4
    }
}
