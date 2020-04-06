import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CorrectData {
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
    public void Positive() throws InterruptedException {
        WebElement Login = findElement(By.xpath("//div[@class='it_w']//input[@name='st.email']"));
        Login.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Login.sendKeys("+79260401669");

        WebElement Password = findElement(By.xpath("//div[@class='it_w']//input[@name='st.password']"));
        Password.sendKeys("ghtdtlvtldtl");

        WebElement Entrance = findElement(By.xpath("//div[@class='mt-5x']//input[@value='Войти в Одноклассники']"));
        Entrance.click();


        //  WebElement Icon = findElement(By.id("topPanelLeftCorner"));
        // Assert.assertTrue("Страница не загрузилась https://ok.ru/", Icon.isDisplayed());

        driver.get("https://ok.ru/settings");
        driver.manage().window().maximize();

        WebElement UserSettings = findElement(By.xpath("//div[@class = 'user-settings_i_tx textWrap']"));
        UserSettings.click();


        WebElement Name = findElement(By.xpath("//div[@class='it_w']//input[@name='fr.name']"));
        Name.click();
        Name.clear();
        Name.sendKeys("Светлана");


        WebElement Surname = findElement(By.xpath("//div[@class='it_w']//input[@name='fr.surname']"));
        Surname.click();
        Surname.clear();
        Surname.sendKeys("Иванова");


        WebElement Sex = findElement(By.xpath("//input[@id='field_gender_2']"));
        Sex.click();


        WebElement City = findElement(By.xpath("//div[@class = 'it_w citycountry_input search-input search-input_searching']//input[@name='fr.citySugg_SearchInput']"));
        City.click();
        City.clear();
        City.sendKeys("Москва, Россия");
        sleep(1000);
        List<WebElement> CityList = driver.findElements(By.xpath("//li[@class='suggest_li']"));
        if (CityList.size() > 0) {
            CityList.get(0).click();

        } else {
            Assert.fail("Список городов пуст. Поле город проживание было заполнено значением " + City.getText());
        }


        WebElement Hometown = findElement(By.xpath("//div[@class = 'it_w citycountry_input search-input search-input_searching']//input[@name='fr.cityBSugg_SearchInput']"));
        Hometown.click();
        Hometown.sendKeys("Москва, Россия");
        sleep(1000);
        CityList = driver.findElements(By.xpath("//li[@class='suggest_li']"));
        if (CityList.size() > 0) {
            CityList.get(0).click();

        } else {
            Assert.fail("Список родных городов пуст. Поле родной город проживание было заполнено значением " + Hometown.getText());
        }


        WebElement Save = findElement(By.xpath("//div[@class='modal-new_cnt']//input[@value='Сохранить']"));
        Save.click();


        //  WebElement YourName = findElement(By.xpath("//span[@class='input-e' and text()='Пожалуйста, укажите ваше имя.']"));
        // Assert.assertTrue("Ошибка", YourName.isDisplayed());
        //  Assert.assertEquals("Пожалуйста, укажите ваше имя.", YourName.getText());


    }


    @After
    public void tearDown() {
        driver.quit();
    }


    public WebElement findElement(By by) {
        return driver.findElement(by);
    }
}
