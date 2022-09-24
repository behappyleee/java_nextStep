package net.servlet;

import java.io.File;


import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class WebServerLauncher {
	
	// EmbedTomcat 설정 추가 
    public static void main(String[] args) throws Exception {
    	
    	System.out.println("WEB SERVER LAUNCHER TEST !!!!");
    	
        String webappDirLocation = "webapp/";
        Tomcat tomcat = new Tomcat();
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
         
        tomcat.setPort(Integer.valueOf(webPort));
        Connector connector = tomcat.getConnector();
        connector.setURIEncoding("UTF-8");
        
        // webapp/ 하위를 root 로 인식하도록 설정 
        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());
        tomcat.start();
        tomcat.getServer().await(); 
    }
}
