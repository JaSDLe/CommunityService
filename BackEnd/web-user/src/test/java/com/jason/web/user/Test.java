package com.jason.web.user;

import java.util.UUID;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        System.out.println(Pattern.matches("^[0-9a-zA-Z]+$", "-"));
        System.out.println(Pattern.matches("^[0-9a-zA-Z~!@#$%^&*()_+-=]{6,20}$", "------"));
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid.length());
        System.out.println(uuid);
        System.out.println(uuid.replace("-", ""));
    }
}
