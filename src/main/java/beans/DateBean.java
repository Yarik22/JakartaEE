package beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Locale;

public class DateBean {
    private Date currentDate;
    private String formattedDate;

    public DateBean() {
        this.currentDate = new Date();
        setLocationAndFormat("Europe/Kyiv", "dd MMMM yyyy HH:mm:ss", Locale.ENGLISH);
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setLocationAndFormat(String timeZoneId, String dateFormat, Locale locale) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, locale);
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
        sdf.setTimeZone(timeZone);
        this.formattedDate = sdf.format(this.currentDate);
    }
}
