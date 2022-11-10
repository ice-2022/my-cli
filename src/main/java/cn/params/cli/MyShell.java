package cn.params.cli;

import cn.params.cli.cmd.*;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "my",
        subcommands = {
                IPTool.class,
                FindIPTool.class,
                DateTool.class,
                TimeTool.class},
        mixinStandardHelpOptions = true, version = "1.0.0", description = "my tool.")
public class MyShell implements Callable<Integer> {

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public Integer call() throws Exception {
        throw new CommandLine.ParameterException(spec.commandLine(), "Missing required subcommand");
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new MyShell()).execute(args);
        System.exit(exitCode);
    }
}
