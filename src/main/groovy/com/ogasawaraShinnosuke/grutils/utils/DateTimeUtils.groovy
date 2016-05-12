package com.ogasawaraShinnosuke.grutils.utils

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

    private static def isZero(since, until) {
        since == null || until == null || since == until
    }
}
