package udemySQLDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JDBCconnection {
	
	public static void main(String[] args) throws SQLException   {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaju_v\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
	// TODO Auto-generated method stub

	String host ="localhost";

	String port= "3306";
	
//	String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC"
			
	Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qajdbc", "root", "Mysql123$");

//	Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "qajdbc", "root", "Mysql123$");

	Statement s=con.createStatement();

	ResultSet rs =  s.executeQuery("select * from credentials where scenario ='rewardstypecard'");
	
	while (rs.next()) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/?ir=1");
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys((rs.getString("username")));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys((rs.getString("password")));
//		driver.findElement(By.xpath("//input[@id='Login']")).click();
//  System.out.println(rs.getString("username"));
//  System.out.println(rs.getString("password"));
  
	}

//	while(rs.next())
//
//	{

//	WebDriver driver= new FirefoxDriver();
//
//	driver.get("https://login.salesforce.com");
//
//	driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));
//
//	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));
//
//	}

	}

	

}




