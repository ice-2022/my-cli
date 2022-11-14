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
            versionFile = new File("../version.txt"); // brew
        }
        Properties properties = new Properties();
        properties.load(new FileInputStream(versionFile));
        return new String[]{properties.getProperty("version")};
    }
}
