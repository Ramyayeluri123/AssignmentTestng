package TestClass;

import Assignment.Tframework;
import Pages.*;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class Testexecution extends Tframework {
    public Customerlogin CustomerLogin;
    public Gearspage GearsPage;
    public Highestprice HighestPrice;
    public Verifycart VerifyCart;
    public  Address Address;
    public Cancelling Cancelling;

    @Test(priority = 1)

    public void setCustomerLogin() throws InterruptedException {
        Customerlogin CustomerLogin = new Customerlogin(driver);
        CustomerLogin.CustomerLoginDetails();
    }

    @Test(priority = 2)
    public void Gearspage() throws InterruptedException {
        Gearspage GearsPage = new Gearspage(driver);
        GearsPage.selectBag();
        GearsPage.verifingCartisEmpty();
    }

    @Test(priority = 4)
    public void HighestPrice() throws InterruptedException {
        Highestprice HighestPrice = new Highestprice(driver);
        HighestPrice.setMaxproductAmount();
        HighestPrice.addToWishlist();
        HighestPrice.setAddtocart();
    }
    @Test(priority = 3)
    public void VerifyCart() throws InterruptedException{
        Verifycart verifyCart = new Verifycart(driver);
        verifyCart.CartIsEmpty();
    }
    @Test(priority = 5)
    public void Address() throws InterruptedException, FileNotFoundException {
        Address address=new Address(driver);
     Thread.sleep(3000);
        address.fillAddressOfCustomer();
    }
    @Test(priority = 6)
    public void Cancelling() throws InterruptedException {
        Cancelling Cancelling=new Cancelling(driver);
        Cancelling.placingTheOrder();
    }
}