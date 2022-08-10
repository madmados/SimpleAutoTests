package PageObj;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")
    private SelenideElement searchField;
    @FindBy(how = How.CLASS_NAME, using = "gNO89b")
    private SelenideElement searchButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"hdtb-msb\"]/div[1]/div/div[4]/a")
    private SelenideElement clickImages;
    @FindBy(how = How.XPATH, using = "//*[@id=\"islrg\"]/div[1]/div[3]/a[1]/div[1]/img")
    private SelenideElement clickImage;

    public void takePic(String type) {
        searchField.setValue(type);
        searchButton.click();
        clickImages.click();
        clickImage.click();
    }
}
