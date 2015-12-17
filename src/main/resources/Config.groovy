url = System.getProperty("URL",'http://stackoverflow.com')

// the setting is useful if we need to take a screenshot after every action
// functionality for screenshots still to be added to application
take_screenshot = false

// timeout for implicit and webdriverwait
WEBDRIVERWAIT_TIMEOUT = 30
IMPLICITWAIT_TIMEOUT = 10
// webdriverwait polling timeout in milliseconds
WEBDRIVERWAIT_POLL = 10


seleniumConfigs {
	local {
		browser = System.getProperty("BROWSER",'chrome')
	}
	remote {
		ip = System.getProperty("SELENIUM_HOST", "localhost")
		port = Integer.valueOf(System.getProperty("SELENIUM_PORT", "4444"))
		browser = System.getProperty("BROWSER",'firefox')
		version = '41'
		platform = 'ANY'
	}
	mobile {
		ip = System.getProperty("SELENIUM_HOST", "localhost")
		port = Integer.valueOf(System.getProperty("SELENIUM_PORT", "4723"))
		browser = System.getProperty("BROWSER",'Browser')
		platform = 'Android'
		deviceName = 'Android Emulator'
		platformVersion = '4.4.2'
	}
	sauceLabs {
		userName = ''
		accessKey = ''
		os = 'Windows 8'
		browser = System.getProperty("BROWSER",'firefox')
		browserVersion = '41'
		onDemand {
			server = 'ondemand.saucelabs.com'
			port = '80'
		}
	}
}