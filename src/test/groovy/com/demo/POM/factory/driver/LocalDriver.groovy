package com.demo.POM.factory.driver

import com.demo.POM.factory.FrameworkConfig;

import java.nio.file.Path

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities

/**
 * The class extends @see com.sand.base.Driver abstract class to provide driver creation specifically for local
 * webdriver instances.
 */

/**
 * @author SANDEEP
 *
 */
class LocalDriver extends Driver {
	
	public LocalDriver() {
		super()
	}

	/**
	 * @see com.demo.POM.factory.factory.driver.Driver#createDriver()
	 * Creates an instance of a browser webdriver based on
	 * the browser name stored in the Config.groovy file.
	 * The WebDriver exes are stored in the lib folder relative
	 * to the source root folder.
	 */
	@Override
	WebDriver createDriver() {
		def browser = config.seleniumConfigs.local.browser
		//println "creating new ${browser} instance"
		if(driver == null) {
			String path
			if(browser.toLowerCase().contains("firefox")) {
				return new FirefoxDriver()
			} else if (browser.toLowerCase().contains("chrome")) {
				// if the OS the test is being run on is Windows then
				// use the chromedriver.exe file for driver initialization
				if (System.getProperty("os.name").contains("Windows")) {
					path = createDriverIfDriverFileExists('chromedriver.exe')
				}
				
				// if the above if fails - i.e., the OS is not Windows
				// then set the path of the chrome driver to chromedriver
				path = createDriverIfDriverFileExists('chromedriver.exe')

				System.setProperty("webdriver.chrome.driver", path)
				return new ChromeDriver()
			} else if(browser.toLowerCase().contains("internet")) {
				if (System.getProperty("os.name").contains("Windows")) {
					path = createDriverIfDriverFileExists("IEDriverServer.exe")
				}
				System.setProperty("webdriver.ie.driver", path)
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer()
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true)
				return new InternetExplorerDriver(capabilities)
			} else if(browser.toLowerCase().contains("safari")) {
				// TODO: yet to be implemented.
				println "driver creation yet to be implemented for browser: ${browser}"
			} else {
				throw new RuntimeException("Unknown Browser ${browser} Type. Unable to create browser instance.")
			}
		} else {
			return driver
		}
	}

	private String createDriverIfDriverFileExists(String driverFileName) {
		def path = new File("lib/${driverFileName}")
		if(path.exists()) {
			return path.toString()
		} else {
			println "Chrome driver file could not be found at location: lib"
		}
	}

}
