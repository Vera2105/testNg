package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RepositoryPage extends BasePage {
    WebElement findField = driver.findElement(By.xpath("//input[@placeholder ='Find a repository…']"));
    WebElement reposList = driver.findElement(By.xpath("//ul[@data-filterable-for='your-repos-filter']"));

    public final static String TITLE = "Repository Menu";

    public RepositoryPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public RepositoryPage navigateToFindField(String data) {
        findField.click();
        findField.sendKeys(data);
        return new RepositoryPage(driver);
    }

    public int getReposList(String dataFrominput) {
        driver.get("https://github.com/TestAutomation777?tab=repositories&q=data&type=&language=&sort=)".replace("data", dataFrominput));
        WebElement reposListFiltered = driver.findElement(By.xpath("//*[@id=\"user-repositories-list\"]/ul"));
        List<WebElement> li_All = reposListFiltered.findElements(By.tagName("li"));
        return li_All.size();
    }


}
