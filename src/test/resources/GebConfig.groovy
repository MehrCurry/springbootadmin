/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile

driver = {
    FirefoxProfile profile = new FirefoxProfile()
    new FirefoxDriver(profile)
}

baseUrl = "http://localhost:8188"

reportsDir = new File("target/geb-reports")
reportOnTestFailureOnly = true
