package Pages;

import Generics.Commonmethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Highestprice {
  public   WebDriver driver;

  Commonmethods commonMethods;

    Double maxproductamount;

  public Highestprice(WebDriver driver) {
      this.driver=driver;
      PageFactory.initElements(driver,this);
      commonMethods = new Commonmethods(driver);
  }

    @FindBy(xpath = "//fieldset[@class='fieldset']/div/following-sibling::div/div/button[@title='Add to Cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//li[@data-row='product-item']")
    WebElement moveToImg;


    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement cartIconButton;


    @FindBy(xpath = "//div[@class='primary']/button[text()='Proceed to Checkout']")
    WebElement proceedToCheckoutButton;







    //this is for verifying maximumprice product and add to cart
    public void setMaxproductAmount() throws InterruptedException {
        List<WebElement> listofallprices = new ArrayList<WebElement>();
        listofallprices = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
        List<Double> allproductsamount = new ArrayList<>();
        for (WebElement webElement : listofallprices) {
            allproductsamount.add(Double.parseDouble(webElement.getText().replace("$", "")));
        }
        System.out.println(Collections.max(allproductsamount));
        maxproductamount = Collections.max(allproductsamount);
        System.out.println("max amount" + maxproductamount);
       WebElement highestpriceproduct = driver.findElement(By.xpath("//span[@data-price-type='finalPrice']/span[contains(.,'" + maxproductamount + "')]/parent::span/parent::span/parent::div/preceding-sibling::strong/a"));
        System.out.println(highestpriceproduct.getText());
        commonMethods.actionsMoveToElement(highestpriceproduct);

    }
    public void  addToWishlist() throws InterruptedException {
        WebElement wishlistIcon = driver.findElement(By.xpath("//span[@class='price-wrapper ']//span[contains(text(),'"+maxproductamount+"')]/../../..//following-sibling::div//child::div/div//following-sibling::div/a"));
        commonMethods.actionsMoveToElement(wishlistIcon);
        commonMethods.clickOnElement(wishlistIcon);
//        addtowishlist.click();
        commonMethods.actionsMoveToElement(moveToImg);

//        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='You have no items in your wish list.']")).isDisplayed());
    }
    //this is used to adding to cart
    public  void  setAddtocart() throws InterruptedException {

        commonMethods.clickOnElement(addToCartButton);
        Thread.sleep(3000);
        commonMethods.clickOnElement(cartIconButton);
        commonMethods.clickOnElement(proceedToCheckoutButton);

    }
}

