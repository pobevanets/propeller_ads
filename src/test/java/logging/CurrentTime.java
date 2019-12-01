package logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    private static DateFormat dateFormatForFileName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

    static String getCurrentTime(){
        Date date = new Date();
        return dateFormat.format(date);
    }

    static String getCurrentTimeForFileName(){
        Date date = new Date();
        return dateFormatForFileName.format(date);
    }
}
