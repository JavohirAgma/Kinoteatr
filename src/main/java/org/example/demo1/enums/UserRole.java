package org.example.demo1.enums;

import java.util.StringJoiner;

public enum UserRole {
    USER,
    CONSUMER,
    ADMIN;
    public static String show() {
        StringJoiner joiner = new StringJoiner("\n");
        UserRole[] values = values();
        for (UserRole value : values) {
            joiner.add((value.ordinal()+1)+"."+value.name());
        }
        return joiner.toString();
    }
    public static UserRole getCategoryByOrdinal(Integer ordinal) {
        for (UserRole value : values() ) {
            if (value.ordinal()==ordinal-1)
                return value;
        }
        return null;
    }
    public static Integer getOrdinalBYCategory(UserRole value) {
        for (UserRole value1 : values() ) {
            if (value1.equals(value))
                return value1.ordinal()+1;
        }
        return null;
    }
}
