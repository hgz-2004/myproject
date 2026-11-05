package mobileshop;

import org.apache.catalina.startup.Tomcat;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.Properties;

public class Application {
    private int port = 8082;
    private String contextPath = "";
    public void start() throws Exception {
        Tomcat tomcat = new Tomcat();
        URL url = getClass().getClassLoader().getResource("spring-mvc.xml");

        System.out.println("URL path:"+url.getPath());
        String pwd = StringUtils.substringBefore(url.getPath(), "/target/classes");
        System.out.println("BaseDir:"+pwd);
        tomcat.setBaseDir(pwd);
        tomcat.setPort(port);

        StringBuilder webAppBuilder = new StringBuilder();
        webAppBuilder.append(pwd).append(File.separator).append("target/mobileshop");
        String webapp = webAppBuilder.toString();

        tomcat.addWebapp(contextPath, webapp);
        tomcat.enableNaming();
        tomcat.start();
        tomcat.getServer().await();
    }

    public static void main(String[] args) throws Exception {
        Application starter = new Application();
        starter.start();
    }
}
