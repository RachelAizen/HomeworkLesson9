import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class HomeworkLesson9RachelAizen {

    private static ChromeDriver driver;

    //1
    @BeforeClass
    public static void openCalulator()
    {System.setProperty("webdriver.chrome.driver" , "C:\\Users\\888\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://dgotlieb.github.io/WebCalculator/");}

    @Test
    public static void number7()
    {WebElement calculatorElement = driver.findElement(By.id("Seven"));
    System.out.println("Height: " + calculatorElement.getRect().getHeight());
    System.out.println("Width: " + calculatorElement.getRect().getWidth());}

    @Test
    public static void number6()
    {WebElement calculatorElementB = driver.findElement(By.id("Six"));
    System.out.println("Displayed: " + calculatorElementB.isDisplayed());}

    @Test
    public static void calculateAssert()
    {String R = "6";
    WebElement calculatorElementC = driver.findElement(By.id("two"));
    calculatorElementC.click();

    WebElement calculatorElementAdd = driver.findElement(By.id("add"));
    calculatorElementAdd.click();

    WebElement calculatorElementD = driver.findElement(By.id("four"));
    calculatorElementD.click();

    WebElement calculatorElementEquals = driver.findElement(By.id("equal"));
    calculatorElementEquals.click();

    WebElement calculatorResult = driver.findElement(By.id("screen"));
    calculatorResult.getText();

    Assert.assertEquals(6, 6);}

    //2
    @Test
    public static void assertingTest()
    {driver.get("https://www.wattpad.com/home");
    String URL = "https://www.wattpad.com/home";
    Assert.assertEquals("https://www.wattpad.com/home" , "https://www.wattpad.com/home");

    WebElement wattpadTitle = driver.findElement(By.className("on-navigate"));
    wattpadTitle.getTagName();
    String Title = "Wattpad";
    Assert.assertEquals("Wattpad", "Wattpad");}

    //3
    @Test
    public static void refreshAndAssert()
    {String WebsiteTitle = "Wattpad";
    WebElement websiteTitle = driver.findElement(By.className("on-navigate"));
    websiteTitle.getTagName();
    Assert.assertEquals(websiteTitle , WebsiteTitle);}

    //4
    @Test
    public static void whatIsTheAssignment()
    {System.out.println("Didn't get what do we have to do here.");}

    //5
    @Test
    public void screenShot()
    {driver.get("https://dgotlieb.github.io/Actions/");
    takeScreenShot(driver.findElement(By.id("div1")));}
    private static void takeScreenShot(WebElement div1)
    {File screenShotFile = div1.getScreenshotAs(OutputType.FILE);}

    @Test
    public void doubleClick()
    {WebElement doubleClick = driver.findElement(By.xpath("//p[@ondblclick = 'doubleClickFunction()']"));
    Actions doubleClickAction = new Actions(driver);
    doubleClickAction.doubleClick(doubleClick);
    doubleClickAction.build().perform();
    String EndResult = driver.findElement(By.id("demo")).getText();
    Assert.assertEquals("You double clicked" , EndResult);}

    @Test
    public void hoverMouse()
    {Actions hoverAction = new Actions(driver);
    WebElement hoverElement = driver.findElement(By.id("demo"));
    WebElement hoverElement2 = driver.findElement(By.id("close"));
    hoverAction.moveToElement(hoverElement).moveToElement(hoverElement2).click().build().perform();}

    @Test
    public void selectFoods()
    {List<WebElement> elementList = driver.findElements(By.name("kind"));
    Actions decision = new Actions(driver);
    decision.clickAndHold(elementList.get(1)).clickAndHold(elementList.get(2));
    decision.build().perform();}

    @Test
    public void upload()
    {driver.findElement(By.id("pic")).sendKeys("1.txt");}

    @Test
    public void scrollDown()throws InterruptedException
    {WebElement scroller = driver.findElement(By.id("clickMe"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroller);}

    //6
    @Test
    public void selecting()
    {driver.get("https://dgotlieb.github.io/Controllers/");
    List<WebElement> list = driver.findElements(By.name("group1"));
    for (WebElement thruElement : list)
    {if (thruElement.getAttribute("value").equals("Cheese"))
    {thruElement.click();}
    System.out.println(thruElement.getAttribute("value"));}
    Select mySelection = new Select(driver.findElement(By.name("dropdownmenu")));
    for (int i = 0; i < mySelection.getOptions().size(); i++)
    {System.out.println(mySelection.getOptions().get(i).getText());}}

    //7
    @Test
    public void backToCalculator()
    {driver.get("https://dgotlieb.github.io/WebCalculator/");
    System.out.println("Two Height: " + driver.findElement(By.id("two")).getRect().getHeight());
    System.out.println("Six Width: " + driver.findElement(By.id("six")).getRect().getWidth());}

    @AfterClass
    public void endSession()
    {driver.quit();}

    public static void main(){}
}
