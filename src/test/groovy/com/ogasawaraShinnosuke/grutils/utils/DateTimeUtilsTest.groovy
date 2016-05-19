package com.ogasawaraShinnosuke.grutils.utils

import constants.DateFormat
import org.joda.time.DateTime
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by shinnosuke on 2016/05/12.
 */
class DateTimeUtilsTest extends Specification {
    void setup() {

    }

    void cleanup() {

    }

    @Unroll
    def "BetweenMonths"() {
        expect:
        DateTimeUtils.betweenMonths(since, until, null) == result

        where:
        since                  | until                  || result
        new Date('2014/05/05') | new Date('2016/05/05') || 25
        new Date('2015/05/05') | new Date('2010/01/05') || 65
        new Date('2015/05/05') | new Date('2015/05/06') || 1
        new Date('2015/05/05') | new Date('2015/05/05') || 0
        new Date('1900/01/01') | new Date('9999/12/31') || 97200
        new Date('2015/05/05') | null                   || 0
        null                   | new Date('2015/05/05') || 0
        null                   | null                   || 0
    }

    @Unroll
    def "BetweenMonths1"() {
        expect:
        DateTimeUtils.betweenMonths(since, until, null) == result

        where:
        since                      | until                      || result
        new DateTime('2014-05-05') | new DateTime('2016-05-05') || 25
        new DateTime('2015-05-05') | new DateTime('2010-01-05') || 65
        new DateTime('2015-05-05') | new DateTime('2015-05-06') || 1
        new DateTime('2015-05-05') | new DateTime('2015-05-05') || 0
        new DateTime('1900-01-01') | new DateTime('9999-12-31') || 97200
        new DateTime('2015-05-05') | null                       || 0
        null                       | new DateTime('2015-05-05') || 0
        null                       | null                       || 0
    }

    @Ignore
    def "toSerialMonths"() {

    }

    @Unroll
    def "plusDate"() {
        expect:
        DateFormat.YYYYMMDD.parse(DateTimeUtils.plusDate(date, y, m, d)) == result

        where:
        date                   | y | m | d | result
        new Date()             | 0 | 0 | 0 | DateFormat.YYYYMMDD.parse(new Date())
        new Date('2018/04/01') | 1 | 5 | 8 | DateFormat.YYYYMMDD.parse(new Date('2019/09/09'))
        new Date('2018/04/01') | 1 | 5 | 0 | DateFormat.YYYYMMDD.parse(new Date('2019/09/01'))
        new Date('2018/04/01') | 1 | 0 | 0 | DateFormat.YYYYMMDD.parse(new Date('2019/04/01'))
        new Date('2018/04/01') | 0 | 0 | 0 | DateFormat.YYYYMMDD.parse(new Date('2018/04/01'))
        null                   | 0 | 0 | 0 | DateFormat.YYYYMMDD.parse(new Date())
    }
}