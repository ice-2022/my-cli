package cn.params.cli.cmd;

import cn.params.cli.util.IPUtils;
import picocli.CommandLine;

@CommandLine.Command(name = "fip", description = "find ip location")
public class FindIPTool extends BaseTool {

    @CommandLine.Parameters(index = "0", description = "the address")
    private String ip;

    @Override
    public Integer call() throws Exception {
        IPUtils.IPInfo ipInfo = IPUtils.getIpInfoInCN(ip);
        show("ip:");
        show(ip);
        show("city:");
        show(ipInfo.city());
        show("operator:");
        show(ipInfo.operator());
        return 1;
    }
}
