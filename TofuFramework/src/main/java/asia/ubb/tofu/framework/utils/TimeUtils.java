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
                        seconds += charInLong * 31556952;
                        break;

                    case 'M':
                        seconds += charInLong * 2629746;
                        break;

                    case 'd':
                        seconds += charInLong * 86400;
                        break;

                    case 'h':
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
