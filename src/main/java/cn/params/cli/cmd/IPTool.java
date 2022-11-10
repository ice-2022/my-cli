package cn.params.cli.cmd;

import cn.params.cli.util.IPUtils;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "ip", description = "local ip information")
public class IPTool implements Callable<Integer> {

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public Integer call() throws Exception {
        printLocalAddress();
        printRemoteAddress();
        return 1;
    }

    private void printLocalAddress() throws Exception {
        String ip = IPUtils.getLocalIP();
        spec.commandLine().getOut().println("local:");
        spec.commandLine().getOut().println(ip);
    }

    private void printRemoteAddress() throws Exception {
        spec.commandLine().getOut().println("remote-国外:");
        spec.commandLine().getOut().println(IPUtils.getRemoteIPInUS());
        spec.commandLine().getOut().println("remote-国内:");
        spec.commandLine().getOut().println(IPUtils.getRemoteIPInCN());
    }
}
