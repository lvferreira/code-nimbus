package log;

import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
//import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//import resources.DataFormats;

import static org.testng.Assert.assertEquals;

public class LoggerTestNG {

	private Logger logger;

	@BeforeTest
	public void setUp() {
		logger = new Logger("out\\test.log");
	}

	@Test
	public void testLogMessage() {
		//String timestamp = DataFormats.getCurrentTimeStamp();
		 //System.out.println(timestamp);
		
		logger.logMessage("User logged in", "INFO");
		logger.logMessage("Failed login attempt", "WARNING");

		String[] expectedLines = { 
				// "[" + timestamp + "] [INFO] User logged in",
				// "[" + timestamp + "] [WARNING] Failed login attempt"
				"[INFO] User logged in",
		        "[WARNING] Failed login attempt"
				};

		/* try (BufferedReader reader = new BufferedReader(new FileReader("out\\test.log"))) {
			for (String expectedLine : expectedLines) {
				String actualLine = reader. readLine();
				assertEquals(expectedLine, actualLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} */
		
		 try (BufferedReader reader = new BufferedReader(new FileReader("out\\test.log"))) {
	        for (String expectedLine : expectedLines) {
	            String actualLine = reader.readLine();
	            assertEquals(expectedLine, actualLine.substring(actualLine.indexOf(']') + 2));
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	} 

	@AfterSuite
	public void tearDown() {
		// Performs cleanup tasks, including closing the logger
		try {
            if (logger != null) {
            	// Clean the log file after the test suite is run 
                // to ensure a clean environment for each test execution
            	logger.clean();
            	// And close it
                logger.close();
            }
            /* // Delete the log file after the test suite is run 
               // to ensure a clean environment for each test execution
            File logFile = new File("out\\test.log");
             if (logFile.exists()) {
                 logFile.delete();
            } */
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
