package com.liferay.sample.module.functional.test.suite;

import com.liferay.gs.testFramework.core.ConcurrentSuite;
import com.liferay.gs.testFramework.driver.WebDriverManager;
import com.liferay.sample.module.functional.test.tests.LiferaySampleAngularTest;
import com.liferay.sample.module.functional.test.tests.LiferaySampleTest;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author diegotomfurtado
 */
@RunWith(ConcurrentSuite.class)
@Suite.SuiteClasses({LiferaySampleTest.class, LiferaySampleAngularTest.class})
public class RunAllTests {

	@AfterClass
	public static void afterClass() {
		_webDriverManager.quitAll();
	}

	private static WebDriverManager _webDriverManager = new WebDriverManager();

}