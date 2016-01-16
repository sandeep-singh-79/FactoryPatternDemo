package com.demo.POM.factory

class FrameworkConfig {
		
	static def getConfig() {
		try {
			return new ConfigSlurper().
					parse(new File("src/test/resources/Config.groovy")
					.toURI().toURL())
		} catch (MalformedURLException e) {
			println("unable to locate Config file.")
			e.getCause()
			e.printStackTrace()
			throw e
			return null;
		}
	}

}