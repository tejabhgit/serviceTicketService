package util;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class CommonUtil {
        public static String uniqueString() {
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            return uuidAsString;
        }

        public static String generateIncrementalNumber() {
            StringBuffer ticketNumber = new StringBuffer();
            ticketNumber.append("T");
            ticketNumber.append(System.currentTimeMillis()+1);
            return ticketNumber.toString();
        }

        public static String generateSystemDate(){
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return formatter.format(new Date(System.currentTimeMillis()));
        }
}
