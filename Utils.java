import java.util.ArrayList;
import java.util.Map;

public abstract class Utils {


    public static boolean isValidIdentifierStart(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch == '_';
    }

    public static boolean isValidIdentifierPart(char ch) {
        return isValidIdentifierStart(ch) || (ch >= '0' && ch <= '9');
    }

    public static boolean isCorrectDigit(char ch, int radix) {
        if (radix == 2) {
            return ch == '0' || ch == '1';
        } else if (radix == 8) {
            return ch >= '0' && ch <= '7';
        } else if (radix == 10) {
            return Character.isDigit(ch);
        } else if (radix == 16) {
            return (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F') || (ch >= 'a' && ch <= 'f');
        }
        return false;
    }

    public static Character escapeChar(char ch) {
        if (ch == '\\' || ch == '\'' || ch == '\"') {
            return ch;
        } else if (ch == 'b') {
            return '\b';
        } else if (ch == 'f') {
            return '\f';
        } else if (ch == 'n') {
            return '\n';
        } else if (ch == 'r') {
            return '\r';
        } else if (ch == 't') {
            return '\t';
        } else {
            return null;
        }
    }
}
