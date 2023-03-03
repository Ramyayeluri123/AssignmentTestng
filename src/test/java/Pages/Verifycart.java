package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verifycart {
    WebDriver driver;

    public Verifycart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@data-block='minicart']")
    WebElement VerifyingTheCart;
    public void CartIsEmpty() throws InterruptedException {
        VerifyingTheCart.click();
        Thread.sleep(3000);
        System.out.println(VerifyingTheCart.isSelected());

    }
}
