url = 'http://stackoverflow.com'

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
		browser = 'chrome'
	}
	remote {
		ip = '127.0.0.1'
		port = '4444'
		browser = 'firefox'
		version = '41'
		platform = 'ANY'
	}
	sauceLabs {
		userName = ''
		accessKey = ''
		os = 'Windows 8'
		browser = 'firefox'
		browserVersion = '41'
		onDemand {
			server = 'ondemand.saucelabs.com'
			port = '80'
		}
	}
	mobile {
		//url = 'http://stackoverflow.com'
		ip = '127.0.0.1'
		port = '4723'
		browser = 'Browser'
		platform = 'Android'
		deviceName = 'Android Emulator'
		platformVersion = '4.4.2'
	}
}