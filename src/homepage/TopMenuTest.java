package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class TopMenuTest extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
    public void selectMenu(By by,String menu){
        WebElement click =driver.findElement(by);
              click.sendKeys(menu);
    }
    @Test
    public void verifyPageNavigation(){
        /*1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
select the Menu and click on it and verify the page navigation.*/
        clickONElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

        //This is requirement
        //Find the welcome test element and get the text//This is requirement
        String actualMsg1=verifyText(By.xpath("//h1[contains(text(),'Computers')]"));
        Assert.assertEquals("Computers",actualMsg1);
    }
}
