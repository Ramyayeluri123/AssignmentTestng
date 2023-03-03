package Generics;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Commonmethods {
    WebDriver driver;
    public Commonmethods(WebDriver driver) {
        this.driver = driver;

    }


    public void clickOnElement(WebElement element){
        try {
            element.click();
        }catch (NoSuchElementException nse){
            nse.printStackTrace() ;
        }catch (ElementClickInterceptedException eci){
            eci.printStackTrace();
        }catch (ElementNotInteractableException ene){
            ene.printStackTrace();
        }
    }
    //this is for click action
    public  void clickingOnWebElement(WebElement element)
    {
        WebDriverWait webwait;
        webwait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }   // sendkeys action
    public  void sendKeysOnWebElement(WebElement element, String text)
    {
        element.sendKeys(text);

    }
    //selecting value from dropdownlist
    public  void selectFromDropDown(WebElement element,int index)
    {
        Select select =new Select(element);
        select.selectByIndex(index);
    }
    //this is for accepting or dismissing alerts
    public void acceptAlerts(WebDriver driver)
    {        driver.switchTo().alert().accept();
    }

    public  void actionsMoveToElement(WebElement element)
    {
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();

    }



}

