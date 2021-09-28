package com.hp.rps.svc.supportticket.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CommonUtil {
        public static UUID uniqueUuid() {
            UUID uuid = UUID.randomUUID();
            return uuid;
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
