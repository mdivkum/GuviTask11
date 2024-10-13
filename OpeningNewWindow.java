package task11.GuviTask11;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpeningNewWindow {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		  String mainwindow=driver.getWindowHandle();
		  Set<String> allwindow=driver.getWindowHandles();
	
	
		Iterator<String> iterator=allwindow.iterator();
		while(iterator.hasNext()) {
			String childwindow=iterator.next();
			
			if(!mainwindow.equals(childwindow)) {
				driver.switchTo().window(childwindow);
				String Text=driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
		
				System.out.println(Text);
				driver.close();
			}
			
		}
		
	

	}

}
