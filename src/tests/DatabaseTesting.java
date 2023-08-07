package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatabaseTesting {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		String host = "localhost";
		String port = "3306";
		String user = "root";
		String password = "$WR3mdK6r28U";
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo",
				user,
				password);
		Statement stat = conn.createStatement();
		ResultSet res = stat.executeQuery("select * from credentials where scenario = 'rewardscard'");
		while (res.next()) {
			WebDriver driver = new ChromeDriver();
			driver.get("https://login.salesforce.com");
			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(res.getString("username"));
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(res.getString("password"));
		}
	}
}
