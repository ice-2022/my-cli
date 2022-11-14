package cn.params.cli;

import cn.params.cli.cmd.DateTool;
import cn.params.cli.cmd.FindIPTool;
import cn.params.cli.cmd.IPTool;
import cn.params.cli.cmd.TimeTool;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "my",
        subcommands = {
                IPTool.class,
                FindIPTool.class,
                DateTool.class,
                TimeTool.class},
        mixinStandardHelpOptions = true,
        versionProvider = VersionProvider.class,
        description = "my tool.")
public class MyShell implements Callable<Integer> {

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public Integer call() {
        throw new CommandLine.ParameterException(spec.commandLine(), "Missing required subcommand");
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new MyShell()).execute(args);
        System.exit(exitCode);
    }
}
