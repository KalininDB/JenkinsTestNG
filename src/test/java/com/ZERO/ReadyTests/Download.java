package com.ZERO.ReadyTests;


import com.ZERO.Tools.Driver;
import com.ZERO.Tools.MainTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Download {

  @Test
  public void tese(){
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().get("http://app.trycloud.net/index.php/login");
        Driver.get().findElement(By.id("user")).sendKeys("User1");
        Driver.get().findElement(By.id("password")).sendKeys("Userpass123");
        Driver.get().findElement(By.id("submit")).click();
        WebElement addButton = Driver.get().findElement(By.xpath("//*[@class='button new']"));
      String path = "/Users/dmitriykalinin/Desktop/Screen Shot 2020-02-05 at 02.53.23.png";
        File f = new File(path);
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        MainTools.waitForClickablility(addButton,10);
        addButton.click();
        WebElement upploadB = Driver.get().findElement(By.xpath("//span[@class = 'svg icon icon-upload']"));
        upploadB.click();
        upploadB.sendKeys(path);
    }

}
