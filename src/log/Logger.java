package log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	private static final String LOG_FORMAT = "[%s] [%s] %s";
	private String logPath;
	private PrintWriter writer;

	public Logger(String filePath) {
		this.logPath = filePath;
		try {
			writer = new PrintWriter(new FileWriter(logPath, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logMessage(String message, String level) {
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String logEntry = String.format(LOG_FORMAT, timestamp, level, message);

		writer.println(logEntry);
	}

	public void close() throws IOException {
		if (writer != null) {
			writer.close();
		}
	}
}
