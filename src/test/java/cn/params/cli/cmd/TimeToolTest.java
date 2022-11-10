package cn.params.cli.cmd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TimeToolTest {

    @Test
    void testWithInput() {
        String[] args = new String[]{"-d 2022-11-09 09:30:01"};
        CommandLine cmd = new CommandLine(new TimeTool());
        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));
        int state = cmd.execute(args);
        Assertions.assertEquals(1667957401000L, Long.parseLong(sw.toString().trim()));
        Assertions.assertEquals(1, state);
    }

    @Test
    void testWithoutInput() {
        String[] args = new String[]{};
        CommandLine cmd = new CommandLine(new TimeTool());
        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));
        int state = cmd.execute(args);
        long diff = Math.abs(System.currentTimeMillis() - Long.parseLong(sw.toString().trim()));
        Assertions.assertTrue(diff <= 1000L);
        Assertions.assertEquals(1, state);
    }

}
