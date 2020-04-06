import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class IncorrectData {
    public WebDriver driver;


    @Before
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ok.ru/");
        driver.manage().window().maximize();

    }


    @Test
    public void Negative() throws InterruptedException {
        WebElement Login = findElement(By.xpath("//div[@class='it_w']//input[@name='st.email']"));
        Login.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Login.sendKeys("**********");

        WebElement Password = findElement(By.xpath("//div[@class='it_w']//input[@name='st.password']"));
        Password.sendKeys("*********");

        WebElement Entrance = findElement(By.xpath("//div[@class='mt-5x']//input[@value='Войти в Одноклассники']"));
        Entrance.click();


        WebElement Icon = findElement(By.id("topPanelLeftCorner"));
        Assert.assertTrue("Страница не загрузилась https://ok.ru/", Icon.isDisplayed());

        driver.get("https://ok.ru/settings");
        driver.manage().window().maximize();


        WebElement UserSettings = findElement(By.xpath("//div[@class = 'user-settings_i_tx textWrap']"));
        UserSettings.click();


        WebElement Name = findElement(By.xpath("//div[@class='it_w']//input[@name='fr.name']"));
        Name.click();
        Name.clear();


        WebElement Surname = findElement(By.xpath("//div[@class='it_w']//input[@name='fr.surname']"));
        Surname.click();
        Surname.clear();


        Select ChooseDay = new Select(driver.findElement(By.xpath("//select[@name='fr.bday']")));
        ChooseDay.selectByVisibleText("день");

        Select ChooseMonth = new Select(driver.findElement(By.xpath("//select[@name='fr.bmonth']")));
        ChooseMonth.selectByVisibleText("месяц");

        Select ChooseYear = new Select(driver.findElement(By.xpath("//select[@name='fr.byear']")));
        ChooseYear.selectByVisibleText("год");


        WebElement City = findElement(By.xpath("//div[@class = 'it_w citycountry_input search-input search-input_searching']//input[@name='fr.citySugg_SearchInput']"));
        City.click();
        City.clear();
        City.sendKeys("Абракадабра");
        sleep(1000);


        WebElement Hometown = findElement(By.xpath("//div[@class = 'it_w citycountry_input search-input search-input_searching']//input[@name='fr.cityBSugg_SearchInput']"));
        Hometown.click();
        Hometown.sendKeys("Абракадабра");


        WebElement Save = findElement(By.xpath("//div[@class='modal-new_cnt']//input[@value='Сохранить']"));
        Save.click();


        WebElement YourName = findElement(By.xpath("//span[@class='input-e' and text()='Пожалуйста, укажите ваше имя.']"));
        Assert.assertTrue("Ошибка", YourName.isDisplayed());
        Assert.assertEquals("Пожалуйста, укажите ваше имя.", YourName.getText());


        WebElement YourSurname = findElement(By.xpath("//span[@class='input-e' and text()='Пожалуйста, укажите вашу фамилию.']"));
        Assert.assertTrue("Ошибка", YourSurname.isDisplayed());
        Assert.assertEquals("Пожалуйста, укажите вашу фамилию.", YourSurname.getText());


        WebElement YourBirthday = findElement(By.xpath("//span[@class='input-e' and text()='День вашего рождения указан некорректно.']"));
        Assert.assertTrue("Ошибка", YourBirthday.isDisplayed());
        Assert.assertEquals("День вашего рождения указан некорректно.", YourBirthday.getText());

        WebElement YourCity = findElement(By.xpath("//span[@class='input-e' and text()='Пожалуйста, выберите место проживания из списка']"));
        Assert.assertTrue("Ошибка", YourCity.isDisplayed());
        Assert.assertEquals("Пожалуйста, выберите место проживания из списка", YourCity.getText());


        WebElement YourHometown = findElement(By.xpath("//span[@class='input-e' and text()='Пожалуйста, выберите родной город из списка.']"));
        Assert.assertTrue("Ошибка", YourHometown.isDisplayed());
        Assert.assertEquals("Пожалуйста, выберите родной город из списка.", YourHometown.getText());

    }


    @After
    public void tearDown() {
        driver.quit();
    }


    public WebElement findElement(By by) {
        return driver.findElement(by);
    }


}





