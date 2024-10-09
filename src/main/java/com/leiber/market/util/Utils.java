package com.leiber.market.util;

/**
 * Utility class for methods to be used in the entire API <br>
 * Created on 08/10/2024 at 10:42:00 pm
 *
 * @author Leiber Bertel
 */
public class Utils {

    private Utils() {
    }

    /**
     * Validates if a property is null
     *
     * @return true/false
     * @author Leiber Bertel
     */
    public static boolean isNull(Integer property) {
        return property == null;
    }
}
