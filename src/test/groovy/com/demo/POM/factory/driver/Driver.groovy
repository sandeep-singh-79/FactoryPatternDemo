package com.demo.POM.factory.driver
import com.demo.POM.factory.FrameworkConfig;
/**
 * The base class for creating a WebDriver instance based on whether the
 * requested driver is local, remote or mobile
 */

/**
 * @author SANDEEP
 *
 */
import org.openqa.selenium.WebDriver

abstract class Driver {
	
	protected WebDriver driver;
	protected ConfigObject config;
	
	public Driver() {
		config = FrameworkConfig.getConfig();
	}
	
	protected abstract WebDriver createDriver();
}
