package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TestCenterPages {
    //kullanici adi
    public SelenideElement kullaniciAdi=$(By.id("exampleInputEmail1"));

    //kullanici sifresi
    public SelenideElement kullaniciSifresi = $ (("#exampleInputPassword1"));

    //submit butonu
    public SelenideElement submit = $(By.xpath("//button[@type='submit']"));

// giris mesaji
    public  SelenideElement mesaj = $(By.xpath("//*[contains(text(),'You logged into a secure area!')]"));

    //checkbox elementleri
public SelenideElement checkbox1=$(By.id("box1"));
public SelenideElement checkbox2=$(By.id("box2"));

//radio elementleri
    public SelenideElement red = $(By.id("red"));
    public  SelenideElement football = $(By.id("football"));

    //dropdown
    public  SelenideElement yil = $(By.id("year"));
    public  SelenideElement ay = $(By.id("month"));
    public  SelenideElement gun = $(By.id("day"));

    //alert stepdef
    public  SelenideElement  promptButton=$(By.xpath("//button[@onclick='jsPrompt()']"));

    public SelenideElement sonuc = $ ("#result"); // css ile locate aldik

    //iframe
public SelenideElement techProLink = $(By.xpath("//a[@type='button']"));

    //actions
    public SelenideElement kaynak=$("#draggable");//css
    public SelenideElement hedef=$("#droppable");//css

    //explicit
    public SelenideElement startButton=$(By.xpath("//div[@id='start']//button"));
    public SelenideElement helloWorld=$(By.xpath("//div[@id='finish']//h4"));


}
