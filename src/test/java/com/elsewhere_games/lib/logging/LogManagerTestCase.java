package com.elsewhere_games.lib.logging;

import com.elsewhere_games.lib.logging.mock.MockAppender;
import org.junit.Assert;
import org.junit.Test;

/**
 * <p>A test case for the {@link LogManager} class.</p>
 */
public class LogManagerTestCase {

	@Test
	public void managerIsASingleton() {
		LogManager instance1 = LogManager.getInstance();
		LogManager instance2 = LogManager.getInstance();

		Assert.assertEquals(instance1, instance2);
	}

	@Test
	public void appendersAreAppliedToExistingLogs() {
		String logName = "new_log";
		Log log = LogManager.getInstance().getLog(logName);
		log.setLevel(Level.DEBUG);

		MockAppender appender = new MockAppender();

		String message = "Test message";
		log.debug(message);

		Assert.assertNull(appender.getLastSource());
		Assert.assertNotEquals(Level.DEBUG, appender.getLastLevel());
		Assert.assertFalse(appender.getLastMessage().equals(message));

		LogManager.getInstance().addAppender(appender);

		log.debug(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.DEBUG, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));
	}

	@Test
	public void appendersAreAppliedToNewLogs() {
		MockAppender appender = new MockAppender();
		LogManager.getInstance().addAppender(appender);

		String logName = "new_log";
		Log log = LogManager.getInstance().getLog(logName);

		String message = "Test message";
		log.debug(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.DEBUG, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));
	}

	@Test
	public void levelsAreAppliedToExistingLogs() {
		String logName = "new_log";
		Log log = LogManager.getInstance().getLog(logName);

		MockAppender appender = new MockAppender();
		log.addAppender(appender);
		log.setLevel(Level.ERROR);

		String message = "Test message";

		log.debug(message);				// Sanity Check

		Assert.assertNull(appender.getLastSource());
		Assert.assertNotEquals(Level.DEBUG, appender.getLastLevel());
		Assert.assertFalse(appender.getLastMessage().equals(message));

		LogManager.getInstance().setLevel(Level.DEBUG);

		log.debug(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.DEBUG, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));
	}

	@Test
	public void levelsAreAppliedToNewLogs() {
		LogManager.getInstance().setLevel(Level.DEBUG);

		String logName = "new_log";
		Log log = LogManager.getInstance().getLog(logName);

		MockAppender appender = new MockAppender();
		log.addAppender(appender);

		String message = "Test message";
		log.debug(message);

		Assert.assertEquals(log, appender.getLastSource());
		Assert.assertEquals(Level.DEBUG, appender.getLastLevel());
		Assert.assertTrue(appender.getLastMessage().equals(message));
	}
}
