package Pages;

import Generics.Commonmethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Gearspage {
    public WebDriver driver;
    Commonmethods CommonMethods;

    public Gearspage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        CommonMethods = new Commonmethods(driver);

    }

    @FindBy(xpath = "//span[text()='Gear']")
    WebElement geardropdown;

    @FindBy(xpath = "//span[text()='Bags']")
    WebElement bags;
    @FindBy(xpath = "//div[@data-block= 'minicart']")
    WebElement cart;
    @FindBy(xpath = "//div[@class='block-content']/button/following-sibling::strong")
    WebElement emptyMesage;

    //this code is for selecting bags from gear
    public void selectBag() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(geardropdown).build().perform();
        actions.moveToElement(bags).click().build().perform();
    }

    //this is for verifying cart is empty
    public void verifingCartisEmpty() {

        cart.click();
        String getTextMsg = emptyMesage.getText();
//        Assert.assertTrue(emptyMesage.isDisplayed());
        System.out.println("empty list : " + getTextMsg);
    }
}