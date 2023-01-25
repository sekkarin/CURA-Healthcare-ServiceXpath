import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

class MakeAppointment {

	@Test
	void TC1001MakeAppointment_Success() throws Exception {
		WebDriver driver = null;

		System.setProperty("webdriver.edge.driver", "C:\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		
		//Page1 Make Appointment
		driver.findElement(By.xpath("//a[contains(text(),'Make Appointment')]")).click();
		
		//Page2 Login
		driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
		driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.xpath("//button[@id='btn-login']")).click();
		
		//Page3 Make Appointment Detail
		Select option1 = new Select(driver.findElement(By.xpath("//select[@id='combo_facility']")));
		option1.selectByVisibleText("Hongkong CURA Healthcare Center");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[2]/div/label")).click();
		Thread.sleep(1000);
		WebElement radio1 = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
		radio1.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//section[@id='appointment']/div/div/form/div[4]/div/div/div/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//tr[3]/td[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@id='txt_comment']")).sendKeys("Heart");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='btn-book-appointment']")).click();
		String result = driver.findElement(By.id("comment")).getText();
		if (result.equalsIgnoreCase("Heart")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		Thread.sleep(2000);
		driver.quit();
		
	}

}