package org.patsimas.happy.enums;

public enum Month {

	JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private final int code;

    Month(int v) {
        code = v;
    }

    public int code() {
        return code;
    }

    public static Month fromCode(int v) {
        for (Month c: Month.values()) {
            if (c.code == v) {
                return c;
            }
        }
        throw new IllegalArgumentException(String.valueOf(v));
    }
}
