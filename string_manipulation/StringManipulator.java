public class StringManipulator {
    public String trimAndConcat(String a, String b) {
        return a.trim().concat(b.trim());
    }
    public Integer getIndexOrNull(String str, char letter) {
        int value = str.indexOf(letter);
        return value == -1 ? null : value;
    }
    public Integer getIndexOrNull(String str, String subStr) {
        int value = str.indexOf(subStr);
        return value == -1 ? null : value;
    }
    public String concatSubString(String str, int a, int b, String str2) {
        String subStr = str.substring(a, b);
        return subStr.concat(str2);
    }
}