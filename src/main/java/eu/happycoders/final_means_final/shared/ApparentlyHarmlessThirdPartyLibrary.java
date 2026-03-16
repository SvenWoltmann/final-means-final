package eu.happycoders.final_means_final.shared;

import java.lang.reflect.Field;

public class ApparentlyHarmlessThirdPartyLibrary {

    private static final String ELLIPSIS3 = "...";

    public static final String EMPTY = "";

    public static String abbreviate(final String str, final int offset, final int maxWidth) {
        return abbreviate(str, ELLIPSIS3, offset, maxWidth);
    }

    public static String abbreviate(final String str, final String abbrevMarker, final int maxWidth) {
        return abbreviate(str, abbrevMarker, 0, maxWidth);
    }

    public static String abbreviate(final String str, String abbrevMarker, int offset, final int maxWidth) {
        if (isEmpty(str)) {
            return str;
        }
        if (abbrevMarker == null) {
            abbrevMarker = EMPTY;
        }
        final int abbrevMarkerLength = abbrevMarker.length();
        final int minAbbrevWidth = abbrevMarkerLength + 1;
        final int minAbbrevWidthOffset = abbrevMarkerLength + abbrevMarkerLength + 1;

        if (maxWidth < minAbbrevWidth) {
            throw new IllegalArgumentException(String.format("Minimum abbreviation width is %d", minAbbrevWidth));
        }
        final int strLen = str.length();
        if (strLen <= maxWidth) {
            return str;
        }
        if (strLen - offset <= maxWidth - abbrevMarkerLength) {
            return abbrevMarker + str.substring(strLen - (maxWidth - abbrevMarkerLength));
        }
        if (offset <= abbrevMarkerLength + 1) {
            return str.substring(0, maxWidth - abbrevMarkerLength) + abbrevMarker;
        }
        if (maxWidth < minAbbrevWidthOffset) {
            throw new IllegalArgumentException(String.format("Minimum abbreviation width with offset is %d", minAbbrevWidthOffset));
        }
        return abbrevMarker + abbreviate(str.substring(offset), abbrevMarker, maxWidth - abbrevMarkerLength);
    }

    public static boolean isBlank(final CharSequence cs) {
        final int strLen = length(cs);
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isMixedCase(final CharSequence cs) {
        if (isEmpty(cs) || cs.length() == 1) {
            return false;
        }
        boolean containsUppercase = false;
        boolean containsLowercase = false;
        final int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            final char nowChar = cs.charAt(i);
            if (Character.isUpperCase(nowChar)) {
                containsUppercase = true;
            } else if (Character.isLowerCase(nowChar)) {
                containsLowercase = true;
            }
            if (containsUppercase && containsLowercase) {
                return true;
            }
        }
        return false;
    }

    public static int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

    public static String lowerCase(final String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    public static String mid(final String str, int pos, final int len) {
        if (str == null) {
            return null;
        }
        if (len < 0 || pos > str.length()) {
            return EMPTY;
        }
        if (pos < 0) {
            pos = 0;
        }
        if (str.length() <= pos + len) {
            return str.substring(pos);
        }
        return str.substring(pos, pos + len);
    }

    static {
        try {
            Field VALUE = Integer.class.getDeclaredField("value");
            VALUE.setAccessible(true);
            VALUE.set(2, 42);
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }
}
