import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import static org.junit.Assert.*;

import org.junit.Test;

public class FormatDateTutor extends Tutor {

    /**
     * Returns date in format dd.mm.yy
     * Use Formatter
     */
    public String getDateByFormatter(Date date) {
        Formatter formatter = new Formatter();



        return formatter.format("%td.%tm.%ty",date, date, date).toString();
    }

    /**
     * Returns date in format "10 of April, 2013"
     * Use Formatter
     */
    public String getDateString(Date date) {
        Formatter formatter = new Formatter();
        return formatter.format("%td of %tB, %tY", date, date, date).toString();
    }

    /**
     * Returns date in format "10.04.13"
     * Use SimpleDateFormat
     */
    public String getDateBySimpleDateFormat(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy");
        return simpleDateFormat.format(date).toString();
    }

    /**
     * Returns date of type Date, converted from the line in format dd.mm.yy
     * Use SimpleDateFormat, method parse()
     */
    public Date parseDDMMYY(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Test
    public void testFormatDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(2013, 4, 1); // 1st of May, 2013
        Date date = cal.getTime();

        String dateByFormatter = getDateByFormatter(date);
        log("dateByFormatter:"+dateByFormatter);
        assertEquals(dateByFormatter, "01.05.13");

        String dateBySimpleDateFormat = getDateBySimpleDateFormat(date);
        log("dateBySimpleDateFormat:"+dateBySimpleDateFormat);
        assertEquals(dateBySimpleDateFormat, "01.05.13");

        System.out.println(getDateString(new Date()));
        //formatNumber();
    }

    @Test
    public void testParseDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(2013, 4, 1, 0, 0, 0); // 1st of May, 2013
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();
        Date d = parseDDMMYY("01.05.13");
        assertEquals(date, d);
    }
}
