package com.training.ers.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;




class ERSTest {
	String browserName="chrome";
	
	WebDriver driver;

	

	@BeforeEach
	void setUp() throws Exception {
		if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

	@Test
	void test() {
		driver.get("http://localhost:8080/alstrom-ers-revature/logIn2.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Nick");
		driver.findElement(By.id("password")).sendKeys("vvvvvvvv");
		driver.findElement(By.id("btnSubmit")).click();
		driver.findElement(By.xpath("/html/body/h1[1]"));
	}

}
