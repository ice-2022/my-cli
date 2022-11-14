package cn.params.cli;

import picocli.CommandLine;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class VersionProvider implements CommandLine.IVersionProvider {
    @Override
    public String[] getVersion() throws Exception {
        File versionFile = new File("./resource/version.txt");
        if (!versionFile.exists()) {
            File home = new File("/opt/homebrew/Cellar/my");
            for (File file : home.listFiles()) {
                if (!file.isDirectory()) {
                    continue;
                }
                String dirName = file.getName();
                String[] tmp = dirName.split("\\.");
                if (tmp.length == 3) {
                    return new String[]{dirName};
                }
            }
        }
        Properties properties = new Properties();
        properties.load(new FileInputStream(versionFile));
        return new String[]{properties.getProperty("version")};
    }
}
