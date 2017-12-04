package cairh.community.api.game.kxian.util;

public class ObjectUtils {

    public static String getString(Object object, String defaultValue) {
        if (object == null) {
            return defaultValue;
        }
        return String.valueOf(object);
    }

    public static String getString(Object object) {
        if (object == null) {
            return "";
        }
        return String.valueOf(object);
    }

    public static int getInt(Object object, int defaultValue) {
        return Integer.parseInt(getString(object, String.valueOf(defaultValue)));
    }

    public static int getInt(Object object) {
        return getInt(object, 0);
    }

    public static long getLong(Object object, long defaultValue) {
        return Long.parseLong(getString(object, String.valueOf(defaultValue)));
    }

    public static long getLong(Object object) {
        return getLong(object, 0);
    }

    public static Double getDouble(Object object) {
        return Double.parseDouble(getString(object));
    }

    public static Double getDouble(Object object, double defaultValue) {
        return Double.parseDouble(getString(object, String.valueOf(defaultValue)));
    }
}
