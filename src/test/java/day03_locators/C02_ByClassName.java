package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        List<WebElement> fiyatListesi= driver.findElements(By.className("a-price-whole"));

        // Webelement bir oibje oldugundan direkt yazdirilamaz

        System.out.println(fiyatListesi);

        // Bunun icin for-each loop kullanarak
        // her bir webelement uzerindeki yazilari tek tek yazdirmaliyiz.

        for (WebElement each:fiyatListesi
             ) {

            System.out.print(each.getText()+ " ");

        }

        // en yuksek fiyati bulabilmek icin java bilgimizi kullanmaliyiz
        // 1- web elementlerden getText ile fiyati String olarak alin
        // 2- string fiyati kiyaslama yapabilmek icin Integer'a cevirin
        // 3- en yuksek fiyati bulup yazdirin

        String fiyatStr;
        Integer fiyatInt;
        Integer enYuksekFiyat=0;

        for (WebElement each: fiyatListesi
        ) {

            fiyatStr= each.getText();
            fiyatInt=Integer.parseInt(fiyatStr);

            if (fiyatInt>enYuksekFiyat){
                enYuksekFiyat=fiyatInt;
            }

        }
        System.out.println("");
        System.out.println("En yuksek urun fiyati : " + enYuksekFiyat);

        Thread.sleep(4000);

        driver.close();


    }
}
