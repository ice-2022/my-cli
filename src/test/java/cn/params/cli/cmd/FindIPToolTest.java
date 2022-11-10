package cn.params.cli.cmd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.io.StringWriter;

public class FindIPToolTest {

    @Test
    void test() {
        String[] args = new String[]{"14.215.177.39"};
        CommandLine cmd = new CommandLine(new FindIPTool());
        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));
        int state = cmd.execute(args);
        Assertions.assertTrue(sw.toString().startsWith("ip:"));
        Assertions.assertEquals(1, state);
    }

}
