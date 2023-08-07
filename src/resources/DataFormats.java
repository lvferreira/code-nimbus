package resources;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormats {

	private static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getCurrentTimeStamp() {
        return TIMESTAMP_FORMAT.format(new Date());
    }

}
