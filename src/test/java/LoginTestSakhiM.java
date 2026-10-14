import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestSakhiM {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
    }

    @Test
    public void clickLoginButton(){
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[1]")).click();
    }

    @Test(dependsOnMethods = "clickLoginButton")
    public void enterUsername(){
        driver.findElement(By.id("login-email")).sendKeys("smlalandle@gmail.com");
    }

    @Test(dependsOnMethods = "enterUsername")
    public void enterPassword(){
        driver.findElement(By.id("login-password")).sendKeys("@12345678");
    }

    @Test(dependsOnMethods = "enterPassword")
    public void clickSubmitButton(){
        driver.findElement(By.id("login-submit")).click();
    }

    @Test(dependsOnMethods = "clickSubmit")
    public void LoginTest(){
        driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/div[1]/h2/span[2]")).isDisplayed();

    }

    @AfterTest
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

}

