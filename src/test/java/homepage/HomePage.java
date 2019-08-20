package homepage;

import basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "https://www.deployinc.com/";

    @FindBy(css = "div.header__brand > a > img")
    private WebElement logo;

    @FindBy(css = "button.button-underlined.large.white")
    private WebElement chat;

    @FindBy(css = "#email")
    private WebElement email;

    @FindBy(css = "#name")
    private WebElement name;

    @FindBy(css = "#phone")
    private WebElement phone;

    @FindBy(css = "#message")
    private WebElement message;

    @FindBy(css = "button.border-btn")
            private WebElement sendbutton;


    HomePage() { PageFactory.initElements(driver, this); }

    void goToHomePage() {

        driver.get(HOME_PAGE_URL);
        wait.forLoading(5);
    }

    void checkTitle(String title) {
        String displayedTitle = driver.getTitle();
        System.out.println(displayedTitle);
        Assert.assertEquals("A Technology Agency | Deploy Inc.", displayedTitle);

    }

    void checkLogoDisplay() { wait.forElementToBeDisplayed(5,this.logo, "Logo");}

    void clickOnChat() { chat.click(); }

    void inputEmailandName() {
        email.sendKeys("shone@getnada.com");
        name.sendKeys("nenad");
        phone.sendKeys("123456");
        message.sendKeys("lorem ipsum blah blah");
        sendbutton.click();

    }

    void Sleep (int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

}
