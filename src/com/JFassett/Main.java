package com.JFassett;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Main {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
	// write your code here
        System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 40);
        driver.manage().window().maximize();
        driver.get("http://testoutlivecontent.blob.core.windows.net/netpro2018v5-en-us/en-us/sims/typescriptv1/netpro2018v5/simstartup_webpack.html?package=netpro2018v5windowspackage&sim=ipademail_np5&dev=true&automation=true");
        clickElementByID("wpDesktop.DesktopIcon15.Grid.gContent.imImage");
        clickElementByID("siMailContactsCalendars.Grid.tbText");
        clickElementByID("lbAccounts.Grid.Border.ScrollViewer.Grid.Viewport.ScrollContentPresenter.OuterElement.InnerElement.ItemsPresenter.StackPanel.SettingsItemSubMenu");
        clickElementByID("siAccount.Grid.rectClickArea");
        clickElementByID("siAdvanced.Grid.rectClickArea");
        dragElement("spAdvanced.TextBlock2", 0, -200);
        dragElement("siUseSSL.Grid.tbOnOff.Grid.SwitchRoot.Canvas.SwitchThumb", 25, 0);
        setElementText("tbServerPort", "993");
        clickElementByID("btnAccount.grid.contentPresenter.TextBlock");
        clickElementByID("btnDone.grid.contentPresenter.TextBlock");
        clickElementByID("siWiFi");
        clickElementByID("SettingsItemNetwork");
        setElementText("psbx", "@CorpNetWeRSecure!&");
        clickElementByID("btnJoin");
        clickElementByID("bDone");

        driver.switchTo().frame(driver.findElement(By.id("_ifrmreport_")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#reportDiv > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)")));
        String actualText = element.getText();
        String expectedText = "Your Score: 1 of 1 (100%)";
        if (expectedText.equals(actualText)) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed to earn score of 100%");
        }

        driver.switchTo().defaultContent();
        driver.quit();
    }

    public static void clickElementByID(String eleID) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(eleID)));
        element.click();
    }

    public static void dragElement(String eleID1, int xOffset, int yOffset) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(eleID1)));
        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.clickAndHold(element)
                .moveByOffset(xOffset, yOffset)
                .release()
                .build();
        action.perform();
    }

    public static void setElementText(String eleID, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(eleID)));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }
}
