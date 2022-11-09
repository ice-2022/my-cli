package sub;

import cn.params.cli.sub.IPTool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.io.StringWriter;

public class IPToolTest {

    @Test
    void test() {
        String[] args = new String[]{};
        CommandLine cmd = new CommandLine(new IPTool());
        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));
        int state = cmd.execute(args);
        Assertions.assertTrue(sw.toString().startsWith("local:"));
        Assertions.assertEquals(1, state);
    }

}
