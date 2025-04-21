package pages;

import dataProvider.ConfigFileReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import utility.BrowserDriver;
import utility.Constants;

import java.io.IOException;
import java.time.Duration;


public class homepage extends BrowserDriver{

    public void navigateHomepage() throws IOException {
        ConfigFileReader configFileReader = new ConfigFileReader();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigFileReader.getApplicationUrl());
    }

    public void forgotLink(){
        driver.findElement(By.xpath(Constants.FORGOT_LINK)).click();
    }

        public void forgotPasswordPage(){
        Assert.assertEquals(Constants.FORGOT_PASSWORD_PAGE_TITLE, driver.getTitle());
    }

}

