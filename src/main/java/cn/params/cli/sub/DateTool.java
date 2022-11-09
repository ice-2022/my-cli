package cn.params.cli.sub;

import cn.params.cli.utils.TimeUtils;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "date", description = "get date")
public class DateTool implements Callable<Integer> {
    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @CommandLine.Option(names = {"--time", "-t"}, description = "timestamp")
    private String time;

    @Override
    public Integer call() throws Exception {
        String date;
        if (time == null) {
            date = TimeUtils.date(TimeUtils.now());
        } else {
            date = TimeUtils.date(Long.parseLong(time.trim()));
        }
        spec.commandLine().getOut().println(date);
        return 1;
    }
}
