package com.demo.POM.factory.driver;
/**
 * The base class for creating a WebDriver instance based on whether the
 * requested driver is local, remote or mobile
 */

/**
 * @author SANDEEP
 *
 */
 
import groovy.util.ConfigObject;

import org.openqa.selenium.WebDriver;

import com.demo.POM.factory.FrameworkConfig;


abstract class Driver {
	
	protected WebDriver driver;
	protected ConfigObject config;
	
	public Driver() {
		config = FrameworkConfig.getConfig();
	}
	
	protected abstract WebDriver createDriver();
}
