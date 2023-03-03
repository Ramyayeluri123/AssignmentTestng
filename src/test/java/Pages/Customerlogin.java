package Pages;

import Generics.Commonmethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customerlogin {
    public WebDriver driver;
    Commonmethods commonMethods;
  public Customerlogin(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver,this);
       commonMethods=new Commonmethods(driver);

  }
  @FindBy(xpath = "//div[@class='panel header']/ul//a[normalize-space()='Sign In']")
  WebElement SignIn;
  @FindBy(name = "login[username]")
    WebElement mailbox;
@FindBy(name = "login[password]")
    WebElement passwordBox;
@FindBy(xpath = "//div[@class='primary']/button[@name='send']")
WebElement LoginButton;


    public void CustomerLoginDetails() throws InterruptedException {

//        Thread.sleep(5000);
        commonMethods.clickingOnWebElement(SignIn);
        commonMethods.sendKeysOnWebElement(mailbox, "yelurir4@gmail.com");
        commonMethods.sendKeysOnWebElement(passwordBox, "Junnu@143");
        LoginButton.click();
//        commonMethods.clickingOnWebElement(LoginButton);
    }
}
