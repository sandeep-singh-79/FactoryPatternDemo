package com.demo.POM.factory.driver

import groovy.util.ConfigObject;

import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

class SauceLabsDriver extends Driver {
	
	public SauceLabsDriver() {
		super()
	}

	@Override
	WebDriver createDriver() {
		def browser = config.seleniumConfigs.sauceLabs.browser
		def userName = config.seleniumConfigs.sauceLabs.userName
		def accessKey = config.seleniumConfigs.sauceLabs.accessKey
		def platform = config.seleniumConfigs.sauceLabs.os
		def version = config.seleniumConfigs.sauceLabs.browserVersion
		def server = config.seleniumConfigs.sauceLabs.onDemand.server
		def port = config.seleniumConfigs.sauceLabs.onDemand.port
		def capabilities
		
		if(driver == null) {
			if(browser.equalsIgnoreCase('firefox')) {
				capabilities = DesiredCapabilities.firefox()
			} else if(browser.equalsIgnoreCase('chrome')) {
				capabilities = DesiredCapabilities.chrome()
			} else if(browser.equalsIgnoreCase('internetExplorer')) {
				capabilities = DesiredCapabilities.internetExplorer()
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true)
			} else if(browser.equalsIgnoreCase('safari')) {
				capabilities = DesiredCapabilities.safari()
			}
		} else {
			return driver
		}
		capabilities.setCapability("platform", platform)
		capabilities.setCapability("version", version)
		this.driver = new RemoteWebDriver(
				new URL('http://${userName}:${accessKey}@${server}:${port}/wd/hub'), capabilities)
			
		return this.driver
	}

}
