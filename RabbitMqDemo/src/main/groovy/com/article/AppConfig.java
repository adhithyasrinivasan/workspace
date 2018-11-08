package com.article;

import org.apache.catalina.connector.Connector;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;


public class AppConfig {
	 	
	@Bean
	public EmbeddedServletContainerFactory  ajpConnector() {
		System.out.println("--setting ajp");
		Connector con=new Connector("AJP/1.3");
		con.setPort(8009);
		con.setRedirectPort(8082);
		con.setSecure(false);
		con.setAllowTrace(false);
		con.setScheme("ajp");
		con.setAttribute("tomcatAuthentication", false);
		
		TomcatEmbeddedServletContainerFactory  tomcat= new TomcatEmbeddedServletContainerFactory ();
		tomcat.addAdditionalTomcatConnectors(con);
		return tomcat;
	}
}
