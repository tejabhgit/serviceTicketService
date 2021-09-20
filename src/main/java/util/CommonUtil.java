package util;

import java.util.UUID;

public class CommonUtil {
        public static String unique() {
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            return uuidAsString;
        }
}
