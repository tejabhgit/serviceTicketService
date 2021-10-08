package com.hp.rps.svc.supportticket.util;

import org.apache.commons.lang3.StringUtils;

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
        ticketNumber.append(System.currentTimeMillis() + 1);
        return ticketNumber.toString();
    }

    public static String generateSystemDate() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return formatter.format(new Date(System.currentTimeMillis()));
    }

    public static UUID nullCheckUuid(String uuid) {
        return StringUtils.isNotBlank(uuid) ? UUID.fromString(uuid) : null;
    }
}
