package asia.ubb.tofu.framework.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimeUtilsTest {

    @Test
    void testParseSecond() {
        Assertions.assertEquals(10, TimeUtils.parseSecond("10s"));
        Assertions.assertEquals(60 * 10, TimeUtils.parseSecond("10m"));
        Assertions.assertEquals(60 * 60 * 10, TimeUtils.parseSecond("10h"));
        Assertions.assertEquals(60 * 60 * 24 * 10, TimeUtils.parseSecond("10d"));
        Assertions.assertEquals(60 * 60 * 24 * 30.42 * 10, TimeUtils.parseSecond("10M"));
        Assertions.assertEquals(60 * 60 * 24 * 30.42 * 12 * 10, TimeUtils.parseSecond("10y"));
    }

}
