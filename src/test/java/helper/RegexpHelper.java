package helper;

public class RegexpHelper {

    public static Integer extractInteger(String element) {
        return Integer.valueOf(element.replaceAll("\\.0*|\\D", ""));
    }
}
