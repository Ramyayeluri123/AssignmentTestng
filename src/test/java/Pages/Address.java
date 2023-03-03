package Pages;

import Generics.Commonmethods;
import JsonReadData.Jsondata;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;


public class Address {
     WebDriver driver;
    Commonmethods commonMethods;
    Jsondata jsonData;

    public Address(WebDriver driver) {
        this.driver = driver;
         PageFactory.initElements(driver,this);
         commonMethods = new Commonmethods(driver);
//         jsonData=new JsonData();
        }


//            @FindBy(xpath = "//input[@name='company']")
//            WebElement companyname;
            @FindBy(xpath = "//input[@ name='street[0]']")
            WebElement addressline1;
            @FindBy(xpath = "//input[@ name='street[1]']")
            WebElement addressline2;
            @FindBy(xpath = "//input[@ name='street[2]']")
            WebElement addressline3;
            @FindBy(xpath = "//input[@ name='city']")
            WebElement cityfield;
            @FindBy(xpath = "//input[@name='postcode']")
            WebElement postcode;
            @FindBy(xpath="//div[@class='field _required']//child::div/select[@name='country_id']")
            WebElement country;
            @FindBy(xpath="//div[@class='field _required']//child::div/select[@name='region_id']")
            WebElement statedropdown;
            @FindBy(xpath = "//input[@name='telephone']")
            WebElement phonenumber;

//            @FindBy(xpath = "//span[text()='Ship here']")
//            WebElement shipherebutton;
            @FindBy(xpath = "//span[text()='Next']/parent::button")
            WebElement nextbutton;



            //this method is used to fill the address
            public void fillAddressOfCustomer () throws FileNotFoundException, InterruptedException {
                Thread.sleep(3300);

//                companyname.sendKeys("MotivityLabs");
                addressline1.sendKeys("Dallascenter");
               /* addressline2.sendKeys("Raidurgmetro");
                addressline3.sendKeys("near IKEA");*/
                cityfield.sendKeys("Hyderabad");

                postcode.sendKeys("500001");
                phonenumber.sendKeys("8688730034");

                Select select = new Select(country);
                select.selectByVisibleText("India");

                Select select1 =new Select(statedropdown);
                select1.selectByVisibleText("Telangana");

//                commonMethods.clickOnElement(shipherebutton);
                Thread.sleep(3000);
                commonMethods.clickOnElement(nextbutton);






//               commonMethods.sendKeysOnWebElement(companyname,jsonData.read("company"));
//                commonMethods.sendKeysOnWebElement(addressline1, jsonData.read("address1"));
//                commonMethods.sendKeysOnWebElement(addressline2,jsonData.read("address2"));
//                commonMethods.sendKeysOnWebElement(addressline3, jsonData.read("address3"));
//                commonMethods.sendKeysOnWebElement(cityfield,jsonData.read("city"));
//                WebElement statedropdown=  driver.findElement(By.name("region_id"));
//                statedropdown.sendKeys("Texas");
//                commonMethods.sendKeysOnWebElement(postcode,jsonData.read("postcode"));
//                commonMethods.sendKeysOnWebElement(phonenumber,jsonData.read("phone"));
//                commonMethods.clickOnElement(shipherebutton);

            }
}








