package info.androidhive.recyclerviewsearch;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Debrup on 07/03/18.
 */

public class PassResponse {
    Double duration;
    Double risetime;

    public PassResponse(){
    }

    public String getDuration() {
        return duration.toString()+" seconds";
    }

    public Double getRisetime() {
        return risetime;
    }

    public String getFormattedRiseTime() {
        long unixSeconds = risetime.longValue();
        // convert seconds to milliseconds
        Date date = new Date(unixSeconds*1000L);
        // the format of date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        // give a timezone reference for formatting (see comment at the bottom)
        sdf.setTimeZone(TimeZone.getDefault());
        String formattedDate = sdf.format(date);

        return formattedDate;
    }
}
