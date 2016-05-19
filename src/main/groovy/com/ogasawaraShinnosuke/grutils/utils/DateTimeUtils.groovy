package com.ogasawaraShinnosuke.grutils.utils

import groovy.time.TimeCategory
import org.joda.time.DateTime
import org.joda.time.Period
import org.joda.time.PeriodType

/**
 * Created by shinnosuke on 2016/05/12.
 */
class DateTimeUtils extends org.joda.time.DateTimeUtils {
    private static final int MONTHS_OF_YEAR = 12

    /**
     * 開始日付と終了日付間の月数を取得.
     * @param since
     * @param until
     * @param periodType
     * @return
     */
    static def betweenMonths(DateTime since, DateTime until, PeriodType periodType) {
        if (isZero(since, until)) {
            return 0
        }
        def period = new Period(since, until, periodType)
        Math.abs(period.getYears() * MONTHS_OF_YEAR + period.getMonths()) + 1
    }

    /**
     * 開始日付と終了日付間の月数を取得.
     * @param since
     * @param until
     * @param periodType
     * @return
     */
    static def betweenMonths(Date since, Date until, PeriodType periodType) {
        if (isZero(since, until)) {
            return 0
        }
        betweenMonths(new DateTime(since), new DateTime(until), periodType)
    }

    /**
     * 開始日付から終了日付までの月数を加算したものを取得.
     * @param since
     * @param until
     * @return
     */
    static def toSerialMonths(Date since, Date until) {
        def date = since
        def dates = []
        use(TimeCategory) { betweenMonths(since, until, null).times { dates.add date + it.months } }
        dates
    }

    /**
     * 指定した日付にそれぞれの年月日を加算したのものを取得.
     * @param date 指定しない場合は現在日時
     * @param year 指定しない場合は0
     * @param month 指定しない場合は0
     * @param day 指定しない場合は0
     * @return
     */
    static def plusDate(Date date, int year = 0, int month = 0, int day = 0) {
        use(TimeCategory) { (date ?: new Date()) + year.years + month.months + day.days }
    }

    private static def isZero(since, until) {
        since == null || until == null || since == until
    }
}
