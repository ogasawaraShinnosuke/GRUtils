package constants

/**
 * Created by shinnosuke on 2016/05/19.
 */
enum DateFormat {
    YYYYMMDD('yyyyMMdd'),
    YYYYMMDD_HYPHEN('yyyy-MM-dd'),
    YYYYMMDD_SLASH('yyyy/MM/dd'),
    YYYYMMDD_SPACE('yyyy MM dd'),
    YYYYMMDD_KANJI('yyyy年MM月dd日')

    String format

    DateFormat(format) {
        this.format = format
    }

    def parse(Date date) {
        date.format(format)
    }
}
