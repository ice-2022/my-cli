package cn.params.cli.cmd;

import cn.params.cli.util.TimeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.io.StringWriter;

public class DateToolTest {

    @Test
    void testWithInput() {
        String[] args = new String[]{"-t 1667965627493"};
        CommandLine cmd = new CommandLine(new DateTool());
        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));
        int state = cmd.execute(args);
        Assertions.assertEquals("2022-11-09 11:47:07", sw.toString().trim());
        Assertions.assertEquals(1, state);
    }

    @Test
    void testWithoutInput() throws Exception {
        String[] args = new String[]{};
        CommandLine cmd = new CommandLine(new DateTool());
        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));
        int state = cmd.execute(args);
        long time = TimeUtils.time(sw.toString().trim());
        long diff = Math.abs(System.currentTimeMillis() - time);
        Assertions.assertTrue(diff <= 1000L);
        Assertions.assertEquals(1, state);
    }

}
