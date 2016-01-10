package com.demo.POM.factory.driver;

import org.openqa.selenium.WebDriver;


public final class WebDriverFactory {
	
	public static WebDriver getDriver(String driverType) {
		switch (driverType) {
			case "local":
				return new LocalDriver().createDriver();
			case "remote":
				return new RemoteDriver().createDriver();
			case "mobile":
				return new MobileDriver().createDriver();
			case "saucelabs":
				return new SauceLabsDriver().createDriver();
			default: throw new Exception ("UnSupported driver type requested: ${driverType}");
		}
	}
}