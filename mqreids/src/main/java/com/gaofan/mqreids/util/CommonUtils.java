package com.gaofan.mqreids.util;

import javax.activation.MailcapCommandMap;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Set;

/**
 * @author gaofan
 * @create 2021-08-29 23:33
 */
public class CommonUtils {

    public static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-mm-dd"));

    public static void main(String[] args) {
        String format = THREAD_LOCAL.get().format(new Date());
        System.out.println(format);
        Instant now = Instant.now();
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
    }

}
