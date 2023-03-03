package Pages;

import Generics.Commonmethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Cancelling {

public WebDriver driver;
    Commonmethods commonMethods;

        public Cancelling(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
            commonMethods = new Commonmethods(driver);
        }
        @FindBy(xpath = "//button[@class='button action continue primary']")
        WebElement next;
        @FindBy(xpath = "//span[text()='Place Order']/parent::button")
        WebElement placeorder;
        @FindBy(xpath="//div[@ class='checkout-success']")    //a[@class='order-number']
        WebElement ordernum;
        @FindBy(xpath = "//div[@class='checkout-success']/p/a")
        WebElement checkout;
        @FindBy(xpath = "//span[@class='base']")
        WebElement ordernumconfirm;
        public void placingTheOrder() throws InterruptedException {

            commonMethods.clickingOnWebElement(next);

            commonMethods.clickOnElement(placeorder);

            //Assert.assertTrue(checkout.isDisplayed());
            System.out.println("Your order number : " + checkout.getText());
            checkout.click();
//            Assert.assertTrue(ordernum.isDisplayed(),ordernumconfirm.getText());
            // System.out.println(ordernum.getText());
            commonMethods.clickOnElement(ordernum);

        }
    }


