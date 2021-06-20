package asia.ubb.tofu.framework.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandUtilsTest {

    @Test
    void testFormatCommandAlias() {
        Assertions.assertEquals("help", CommandUtils.formatCommandAlias("   HelP      "));
    }

}
