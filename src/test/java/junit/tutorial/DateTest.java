package junit.tutorial;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static junit.tutorial.matcher.IsDate.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class DateTest {

    @Test
    public void isDate() throws Exception {
        Calendar cal = new GregorianCalendar(2013, Calendar.NOVEMBER, 30);
        assertThat(cal.getTime(), is(dateOf(2013, 11, 30)));
    }
}
