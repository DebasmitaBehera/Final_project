package com.Easy_Purse.S_S.GenericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	public void maximizewindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void maxnimizewindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void implicitlitywait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public void Closewindow(WebDriver driver) {
		driver.quit();
	}

	public void switchtontitle(WebDriver driver, String partialtitle) {
		Set<String> childWind = driver.getWindowHandles();
		for (String window : childWind) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains(partialtitle)) {
				break;
			}
		}
	}

	public void selectbyVisibletext(WebElement ele, String name) {
		
		Select s = new Select(ele);
		s.selectByVisibleText(name);
	}
	
	public void javascriptexecutor(WebDriver driver,WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
		
	}

}
