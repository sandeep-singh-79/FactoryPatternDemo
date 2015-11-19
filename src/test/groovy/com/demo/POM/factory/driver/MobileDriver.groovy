/**
 * 
 */
package com.demo.POM.factory.driver

import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities

/**
 * @author SANDEEP
 *
 */
class MobileDriver extends Driver {
	//DesiredCapabilities caps
	
	public MobileDriver() {
		super()
	}

	/* (non-Javadoc)
	 * @see com.test.driver.Driver#createDriver(java.lang.String)
	 */
	@Override
	WebDriver createDriver() {
		if(config.seleniumConfigs.mobile.platform.equalsIgnoreCase('android')) {
			def caps = DesiredCapabilities.android()
			caps.setCapability("automationName", "Appium")
			caps.setCapability('browserName', config.seleniumConfigs.mobile.browser)
			caps.setCapability("deviceName", config.seleniumConfigs.mobile.deviceName)
			caps.setCapability("platformName", config.seleniumConfigs.mobile.platform)
			caps.setCapability('platformVersion', config.seleniumConfigs.mobile.platformVersion)
			return (new AndroidDriver(new URL('http://'+config.seleniumConfigs.mobile.ip+':'
				+config.seleniumConfigs.mobile.port+'/wd/hub'), caps))
		}
	}

}
