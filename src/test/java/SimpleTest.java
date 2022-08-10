import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.ru/");
    }
}
