package log;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class LoggerTestNG {

    private Logger logger;

    @BeforeTest
    public void setUp() {
        logger = new Logger("test.log");
    }

    @Test
    public void testLogMessage() {
        logger.logMessage("User logged in", "INFO");
        logger.logMessage("Failed login attempt", "WARNING");

        String[] expectedLines = {
            "[INFO] User logged in",
            "[WARNING] Failed login attempt"
        };

        try (BufferedReader reader = new BufferedReader(new FileReader("test.log"))) {
			for (String expectedLine : expectedLines) {
				String actualLine = reader.readLine();
                assertEquals(expectedLine, actualLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        // Clean up or any necessary steps after the test
    	// Closing any resources or deleting temporary files
        try {
            // Close the logger's file writer if it's open
            logger.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 }

