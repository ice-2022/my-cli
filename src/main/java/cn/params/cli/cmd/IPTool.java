package cn.params.cli.cmd;

import cn.params.cli.util.IPUtils;
import picocli.CommandLine;

@CommandLine.Command(name = "ip", description = "local ip information")
public class IPTool extends BaseTool {

    @Override
    public Integer call() throws Exception {
        printLocalAddress();
        printRemoteAddress();
        return 1;
    }

    private void printLocalAddress() throws Exception {
        String ip = IPUtils.getLocalIP();
        show("local:");
        show(ip);
    }

    private void printRemoteAddress() throws Exception {
        show("remote-国外:");
        show(IPUtils.getRemoteIPInUS());
        show("remote-国内:");
        show(IPUtils.getRemoteIPInCN());
    }
}
