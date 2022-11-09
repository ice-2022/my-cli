package cn.params.cli.sub;

import cn.params.cli.utils.IPUtils;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "fip", description = "find ip location")
public class FindIPTool implements Callable<Integer> {

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @CommandLine.Parameters(index = "0", description = "the address")
    private String ip;

    @Override
    public Integer call() throws Exception {
        IPUtils.IPInfo ipInfo = IPUtils.getIpInfoInCN(ip);
        spec.commandLine().getOut().println("ip:");
        spec.commandLine().getOut().println(ip);
        spec.commandLine().getOut().println("city:");
        spec.commandLine().getOut().println(ipInfo.city());
        spec.commandLine().getOut().println("operator:");
        spec.commandLine().getOut().println(ipInfo.operator());
        return 1;
    }
}
