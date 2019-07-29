package org.patsimas.happy.enums;

public enum Role {
	
    ADMIN(1),
    USER(2);

    private final int code;

    Role(int v) {
        code = v;
    }

    public int code() {
        return code;
    }

    public static Role fromCode(int v) {
        for (Role c: Role.values()) {
            if (c.code == v) {
                return c;
            }
        }
        throw new IllegalArgumentException(String.valueOf(v));
    }

}
