package cn.params.cli.util;

import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class IPUtils {

    public static String getLocalIP() throws Exception {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                if (interfaceAddress.getAddress().isSiteLocalAddress()) {
                    return interfaceAddress.getAddress().getHostName();
                }
            }
        }
        return null;
    }

    public static String getRemoteIPInUS() throws Exception {
        return HttpUtils.get("http://ip.me").trim();
    }

    public static String getRemoteIPInCN() throws Exception {
        return getIpInfoInCN(null).ip();
    }

    public static IPInfo getIpInfoInCN(String inputIp) throws Exception {
        String content;
        String ip;
        if (inputIp == null) {
            content = HttpUtils.get("http://cip.cc");
            int begin = content.indexOf(':') + 1;
            int end = content.indexOf('\n');
            ip = content.substring(begin, end).trim();
        } else {
            content = HttpUtils.get("http://cip.cc/" + inputIp);
            ip = inputIp;
        }

        // get location
        int begin = content.indexOf("数据二\t:") + 5;
        int end = content.indexOf('\n', begin);
        String location = content.substring(begin, end);
        String[] tmp = location.split("\\|");
        String city = tmp[0].trim();
        String operator = tmp[1].trim();
        return new IPInfo(ip, city, operator);

    }

    public record IPInfo(String ip, String city, String operator) {
    }
}
