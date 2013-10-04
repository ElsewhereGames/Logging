package com.elsewhere_games.lib.logging;

// JUnit
import org.junit.Assert;
import org.junit.Test;

/**
 * <p>Test case for the Log class.</p>
 */
public class LogTestCase {

	@Test
	public void createLog() {
		Log log = LogManager.getInstance().getLog("new_log");
		Assert.assertNotNull(log);
	}

}
