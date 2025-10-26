import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));

        WebElement input = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        WebElement message = driver.findElement(By.id("message"));

        if(input.isEnabled() && message.isDisplayed())
        {
          System.out.println("Input field enabled and text visible");
        }
        else{
            System.out.println("Input field is not enabled and text is not visible");
        }

        WebElement button = driver.findElement(By.xpath("//*[@id='input-example']/button")); // re-locate element
        String buttonText = button.getText();

        if (buttonText.equals("Disable")) {
            System.out.println("Button text changed successfully");
        } else {
            System.out.println("Button text did not change correctly.");
        }

        driver.findElement(By.xpath("//*[@id=\"input-example\"]/input")).sendKeys("Bootcamp");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/input")).clear();
        Thread.sleep(500);
        driver.navigate().to("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement A = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        WebElement B = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));

        int columnA = A.getLocation().getY();
        int columnB = B.getLocation().getY();

        if (columnA == columnB) {
            System.out.println("Columns A and B aligns successfully");
        }
        else {
            System.out.println("Columns A and B aligns did not aligns successfully.");
        }
    }
}
