package cn.params.cli.cmd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.io.StringWriter;

public class AmdahlLawToolTest {

    @Test
    void test() {
        String[] args = new String[]{"0.5", "4"};
        CommandLine cmd = new CommandLine(new AmdahlLawTool());
        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));
        int state = cmd.execute(args);
        Assertions.assertTrue(sw.toString().startsWith("speedup(加速比):"));
        String speedup = sw.toString().split("\n")[1].trim();
        Assertions.assertEquals("1.60", speedup);
        Assertions.assertEquals(1, state);
    }

}
