package cn.params.cli.cmd;

import cn.params.cli.util.TimeUtils;
import picocli.CommandLine;

@CommandLine.Command(name = "date", description = "get date")
public class DateTool extends BaseTool {
    @CommandLine.Option(names = {"--time", "-t"}, description = "timestamp")
    private String time;

    @Override
    public Integer call() {
        String date;
        if (time == null) {
            date = TimeUtils.date(TimeUtils.now());
        } else {
            date = TimeUtils.date(Long.parseLong(time.trim()));
        }
        show(date);
        return 1;
    }
}
