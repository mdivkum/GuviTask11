package task11.GuviTask11;

import java.time.Duration;
import java.util.List;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Frames {

	public static void main(String[] args) {

		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		WebElement ele=driver.findElement(By.cssSelector("frame[name='frame-top']"));
		driver.switchTo().frame(ele);
		List <WebElement> frame=driver.findElements(By.tagName("frame"));
		int framesize=frame.size();
		if(framesize==3)
		{
			System.out.println("Number of frames are " +framesize);
		}else {
			System.out.println("Number of frames are not matching");
		}
		 
		WebElement left=driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(left);
		String msg=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
		Assert.assertEquals("LEFT", msg);
		System.out.println("Current frame is "+msg);
		driver.switchTo().parentFrame();
		
		WebElement middle=driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(middle);
		String msg1=driver.findElement(By.xpath("//div[text()='MIDDLE']")).getText();
		Assert.assertEquals("MIDDLE", msg1);
		System.out.println("Current frame is "+msg1);
		driver.switchTo().parentFrame();
		
		WebElement right=driver.findElement(By.xpath("//frame[@name='frame-right']"));
		driver.switchTo().frame(right);
		String msg2=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
		Assert.assertEquals("RIGHT", msg2);
		System.out.println("Current frame is "+msg2);
		driver.switchTo().defaultContent();
		
		WebElement bottom=driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(bottom);
		String msg3=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
		Assert.assertEquals("BOTTOM", msg3);
		System.out.println("Current frame is "+msg3);
		driver.switchTo().parentFrame();
		
		
	}

}
