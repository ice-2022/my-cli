package cn.params.cli.cmd;

import cn.params.cli.util.TimeUtils;
import picocli.CommandLine;

@CommandLine.Command(name = "time", description = "get timestamp")
public class TimeTool extends BaseTool {

    @CommandLine.Option(names = {"--date", "-d"}, description = "date format input(yyyy-MM-dd HH:mm:ss)")
    private String date;

    @Override
    public Integer call() throws Exception {
        long time;
        if (date == null) {
            time = TimeUtils.now();
        } else {
            time = TimeUtils.time(date);
        }
        show(time);
        return 1;
    }
}
