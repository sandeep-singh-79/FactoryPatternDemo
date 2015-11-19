package com.demo.POM.factory;

import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;

import java.io.File;
import java.net.MalformedURLException;


public class FrameworkConfig {
		
	public static ConfigObject getConfig() {
		try {
			return new ConfigSlurper().
					parse(new File("src/main/resources/Config.groovy")
					.toURI().toURL());
		} catch (MalformedURLException e) {
			System.out.println("unable to locate Config file.");
			e.printStackTrace();
			return null;
		}
	}

}
