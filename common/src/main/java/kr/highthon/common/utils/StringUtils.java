package kr.highthon.common.utils;

public class StringUtils {
    public static String repeat(String text, int times) {
        if (text == null) return "";

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(text);
        }
        return builder.toString();
    }

    private StringUtils() {
    }
}
