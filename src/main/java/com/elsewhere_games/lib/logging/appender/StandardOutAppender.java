package com.elsewhere_games.lib.logging.appender;

import com.elsewhere_games.lib.logging.Appender;
import com.elsewhere_games.lib.logging.Level;
import com.elsewhere_games.lib.logging.Log;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * <p>This appender writes log messages to the standard System output streams. 
 * Any error messages are written to the error stream (System.err), other 
 * messages are written to the regular output stream (System.out).</p>
 * 
 * @author Hans Pragt
 *
 */
public class StandardOutAppender implements Appender {

	@Override
	public void write(Log source, Level level, String message) {
		if (level.equals(Level.ERROR)) {
			System.err.println(getCurrentDateTime() + ": " + level + ": " + message);
		} else {
			System.out.println(getCurrentDateTime() + ": " + level + ": " + message);
		}
	}
	
	private String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//get current date time with Date()
		Date date = new Date();
		return dateFormat.format(date);
	}
}
