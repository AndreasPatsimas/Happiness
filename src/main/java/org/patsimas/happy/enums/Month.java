package org.patsimas.happy.enums;

public enum Month {

	JANUARY(0),
    FEBRUARY(1),
    MARCH(2),
    APRIL(3),
    MAY(4),
    JUNE(5),
    JULY(6),
    AUGUST(7),
    SEPTEMBER(8),
    OCTOBER(9),
    NOVEMBER(10),
    DECEMBER(11);

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
