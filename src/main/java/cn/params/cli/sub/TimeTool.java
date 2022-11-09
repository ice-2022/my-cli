package cn.params.cli.sub;

import cn.params.cli.utils.TimeUtils;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "time", description = "get timestamp")
public class TimeTool implements Callable<Integer> {
    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

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
        spec.commandLine().getOut().println(time);
        return 1;
    }
}
