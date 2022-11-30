package cn.params.cli.cmd;

import picocli.CommandLine;

import java.text.DecimalFormat;

@CommandLine.Command(name = "amd", description = "Amdahl's law (阿姆达尔定律计算)")
public class AmdahlLawTool extends BaseTool {

    @CommandLine.Parameters(index = "0", description = "并行计算部分所占比例")
    private float a;

    @CommandLine.Parameters(index = "1", description = "并行处理结点个数")
    private int n;

    @Override
    public Integer call() throws Exception {
        if (a > 1) {
            a = a / 100;
        }
        float speedup = 1 / ((1 - a) + a / n);
        DecimalFormat df = new DecimalFormat("0.00");
        String speedupFormatted = df.format(speedup);
        show("speedup(加速比):");
        show(speedupFormatted);
        return 1;
    }
}
