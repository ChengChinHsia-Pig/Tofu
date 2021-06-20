package asia.ubb.tofu.framework.utils;

public class TimeUtils {

    private TimeUtils() {
    }

    public static long parseSecond(String from) {
        StringBuilder tmp = new StringBuilder();
        long seconds = 0;

        for (char c : from.toCharArray()) {
            if (Character.isDigit(c)) {
                tmp.append(c);
            } else {
                long charInLong = Long.parseLong(tmp.toString().trim());
                switch (c) {
                    case 'y':
                        // 60 * 60 * 24 * 30.42 (cor. to 2 d.p.) * 12
                        seconds += charInLong * 31539456;
                        break;

                    case 'M':
                        // 60 * 60 * 24 * 30.42 (cor. to 2 d.p.)
                        seconds += charInLong * 2628288;
                        break;

                    case 'd':
                        // 60 * 60 * 24
                        seconds += charInLong * 86400;
                        break;

                    case 'h':
                        // 60 * 60
                        seconds += charInLong * 3600;
                        break;

                    case 'm':
                        seconds += charInLong * 60;
                        break;

                    case 's':
                        seconds += charInLong;
                        break;

                    default:
                        break;
                }
                tmp.setLength(0);
            }
        }

        return seconds;
    }

    public static long parseTicks(String from) {
        return parseSecond(from) * 20;
    }

}
