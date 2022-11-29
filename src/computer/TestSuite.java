package computer;

import com.google.common.base.Verify;
import homepage.TopMenuTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

import javax.naming.Name;
import java.util.List;

public class TestSuite extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    /*1.Test name verifyProductArrangeInAlphaBaticalOrder()
    1.1 Click on Computer Menu.
    1.2 Click on Desktop
    1.3 Select Sort By position "Name: Z to A"
    1.4 Verify the Product will arrange in Descending order.*/
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        Actions actions = new Actions(driver);
        // computer to sofware click
        //  1.1 Click on Computer Menu.
        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(computer).click().build().perform();
        // 1.2 Click on Desktop
        WebElement desktops = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(desktops).click().build().perform();
        driver.findElement(By.xpath("//select[@id='products-orderby']")).click();
        //    1.3 Select Sort By position "Name: Z to A"
        clickONElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        //1.4 Verify the Product will arrange in Descending order.*/
        //verifyTextFromElements(By.xpath(""),"");
    }
    /*2. Test name verifyProductAddedToShoppingCartSuccessFully()
2.1 Click on Computer Menu.
2.2 Click on Desktop
2.3 Select Sort By position "Name: A to Z"
2.4 Click on "Add To Cart"
2.5 Verify the Text "Build your own computer"
2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
2.7.Select "8GB [+$60.00]" using Select class.
2.8 Select HDD radio "400 GB [+$100.00]"
2.9 Select OS radio "Vista Premium [+$60.00]"
2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander*/

    @Test
    public void nameverifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(computer).click().build().perform();
        WebElement desktops = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(desktops).click().build().perform();
        Select productOrder = new Select(driver.findElement(By.xpath("//select[@id='products-orderby']")));
        productOrder.selectByIndex(1);
        Thread.sleep(1500);
        clickONElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        //2.5 Verify the Text "Build your own computer"
        String actualMsg = verifyText(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Build your own computer", actualMsg);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
//        Select obj1 = new Select(driver.findElement(By.xpath("C")));
//        obj1.selectByIndex(1);
//        Thread.sleep(2000);
        driver.findElement(By.xpath("//option[@value='1']")).click();

        // 2.7.Select "8GB [+$60.00]" using Select class.
        driver.findElement(By.xpath("//option[@value='5']")).click();

        //2.8 Select HDD radio "400 GB [+$100.00]"
        driver.findElement(By.xpath("//input[@id='product_attribute_3_7']")).click();

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        driver.findElement(By.xpath("//input[@id='product_attribute_4_9']")).click();

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        driver.findElement(By.xpath("//input[@id='product_attribute_5_12']")).click();
        //driver.findElement(By.xpath("//label[contains(text(),'Microsoft Office [+$50.00]")).click();

        Thread.sleep(1500);
        //2.11 Verify the price "$1,475.00"
        String actualMsg2 = verifyText(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals("$1,475.00", actualMsg2);
        Thread.sleep(1500);
        //2.12 Click on " " Button.
        clickONElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top
        //green Bar
        Thread.sleep(1500);
        String actualMsg3 = verifyText(By.xpath("//div[@id='bar-notification']"));
        Assert.assertEquals("The product has been added to your shopping cart", actualMsg3);

        //After that close the bar clicking on the cross button.
        clickONElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        clickONElement(By.xpath("//span[contains(text(),'Shopping cart')]"));

        //2.15 Verify the message "Shopping cart"
        String actualMsg4 = verifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping cart", actualMsg4);
        //Thread.sleep(5000);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(1500);

        clearTest(By.xpath("//td[@class='quantity']/input"));
        sendTextToElement(By.xpath("//td[@class='quantity']/input"), "2");
        clickONElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        String actuakMsg5 = verifyText(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals("$2,950.00", actuakMsg5);

        //2.18 click on checkbox “I agree with the terms of service”
        clickONElement(By.xpath("//input[@id='termsofservice']"));

        //2.19 Click on “CHECKOUT”
        clickONElement(By.xpath("//button[@id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyTextFromElements(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[1]"), "Welcome, Please Sign In!");

//2.21Click on “CHECKOUT AS GUEST” Tab
        clickONElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "kishan ");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Malaviya");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "kishan_0250@yahoo.co.in");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"), "KBbrothersltd");
        sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        Thread.sleep(1500);

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "london");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "115 manor drive north");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "232530");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07534332680");
        //2.23 Click on “CONTINUE”
        clickONElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickONElement(By.xpath("//input[@id='shippingoption_1']"));

        //2.25 Click on “CONTINUE”
        clickONElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

//2.26 Select Radio Button “Credit Card”
        clickONElement(By.xpath("//input[@id='paymentmethod_1']"));

        //2.27 Select “Master card” From Select credit card dropdown
        clickONElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        sendTextToElement(By.xpath("//select[@id='CreditCardType']"), "visa");

        //2.30 Verify “Payment Method” is “Credit Card”
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"kishan malaviya");

        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5555555555554444");

        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"),"03");

        sendTextToElement(By.xpath("//select[@id='ExpireYear']"),"2025");

        sendTextToElement(By.xpath("//input[@id='CardCode']"),"235");

        ////2.29 Click on “CONTINUE”
        clickONElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //   2.30 Verify “Payment Method” is “Credit Card”
        verifyTextFromElements(By.xpath("//li[@class='payment-method']"), "Payment Method: Credit Card");

        //   2.32 Verify “Shipping Method” is “Next Day Air”
        Thread.sleep(1500);
      //verifyTextFromElements(By.xpath("//li[@class='shipping-method']"), "Shipping Method: Ground");

        //   2.33 Verify Total is “$2,950.00”
        verifyTextFromElements(By.xpath("//tr[@class='order-total']/td[2]"), "$2,950.00");

        //  2.34 Click on “CONFIRM”
       clickONElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        //  2.35 Verify the Text “Thank You”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //  2.36 Verify the message “Your order has been successfully processed!”
        verifyTextFromElements(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");

        //  2.37 Click on “CONTINUE”
        clickONElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

        //  2.37 Verify the text “Welcome to our store”
        verifyTextFromElements(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

    }






//


    }




