package com.aghpk.challenger.tools;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

public class DateUtils {
    static public LocalDateTime newEndDate(Long periodUnit, TemporalUnit period) {
        return LocalDateTime.now().plus(periodUnit, period);
    }
}
