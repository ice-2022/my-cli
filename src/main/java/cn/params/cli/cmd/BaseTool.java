package cn.params.cli.cmd;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command
public abstract class BaseTool implements Callable<Integer> {
    @CommandLine.Spec
    private CommandLine.Model.CommandSpec spec;

    protected void show(Object line) {
        spec.commandLine().getOut().println(line);
    }
}
