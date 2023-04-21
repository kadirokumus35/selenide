package stepDefinitions;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.TestCenterPages;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;

public class TestCenterStepDefinitions {

    TestCenterPages tCP=new TestCenterPages();
    @Given("kullanici adini gir")
    public void kullanici_adini_gir() {
        tCP.kullaniciAdi.setValue("techproed");
    }
    @Given("kullanici sifresini gir")
    public void kullanici_sifresini_gir() {
tCP.kullaniciSifresi.setValue("SuperSecretPassword");
    }
    @When("submit buttonuna tikla")
    public void submit_buttonuna_tikla() {
tCP.submit.pressEnter();
    }
    @Then("giris yapildigini test et")
    public void giris_yapildigini_test_et() {
tCP.mesaj.shouldBe(visible);//selenide assertion
        //fail ederse ekran goruntusu otomatik olarak build dosyasina kaydedilir

    }

    @Given("{string} secili degilse sec")
    public void secili_degilse_sec(String text) {

        // eger text = Checkbox 1 ve checkbox secili degilse sec
        if (text.equals("Checkbox 1") && !tCP.checkbox1.isSelected()) {
            tCP.checkbox1.click();
            //   Assert.assertTrue(tCP.checkbox1.isSelected());  Junit assertion
            //   tCP.checkbox1.shouldBe(Condition.checked); //selenide uzun
            tCP.checkbox1.shouldBe(checked);
        }
        if (text.equals("Checkbox 2") && !tCP.checkbox2.isSelected()) {
            tCP.checkbox2.shouldNotBe(checked);//secili degilse
            tCP.checkbox2.click();
            tCP.checkbox2.shouldBe(checked);
        }

        if (text.equals("Red") && !tCP.red.isSelected()) {
            tCP.red.shouldNotBe(checked);//secili olmadigini test ediyoruz ama zaten if icinde yazmistik
            tCP.red.click();//sec
            tCP.red.shouldBe(checked);//secili oldugunu test et

        }

        if (text.equals("Football") && !tCP.football.isSelected()) {
            tCP.football.click();
            tCP.football.shouldBe(checked);
        }
    }


    @And("kullanici yil olarak {int}, ay olarak {string}, gun olarak {int}")
    public void kullaniciYilOlarakAyOlarakGunOlarak(int yil, String ay, int gun) throws InterruptedException {
//        testCenterPage.yil.selectOption(2000);//INDEX = 2000. MAKUL DEGIL.
//        testCenterPage.yil.selectOption(String.valueOf(yil));//METIN = "2000". CALISIR
        tCP.yil.selectOptionByValue(String.valueOf(yil));//VALUE = "2000". CALISIR

        sleep(3000); //HARD WAIT
        Selenide.sleep(3000);

        tCP.ay.selectOption(ay);//GORUNEN METIN ILE SEC ="June". POPULER.

        sleep(3000);

        tCP.gun.selectOption(gun-1);//INDEX = 25-1 = 24. BU 25. gunu secer.

        sleep(3000);



    }


    @And("alert prompt butonuna tiklar")
    public void alertPromptButonunaTiklar() {
        tCP.promptButton.click();

    }

    @And("kullanici alerte {string} metnini yazar ve OK e tiklar")
    public void kullaniciAlerteMetniniYazarVeOKETiklar(String arg0) {
        switchTo().alert().sendKeys(arg0);// alert e feature den gelen girdi
        sleep(3000);
        switchTo().alert().accept();// ok e tikladik
        sleep(3000);
    }

    @Then("kullanici sonucun {string} icerdigini dogrular")
    public void kullaniciSonucunIcerdiginiDogrular(String dogruladik) {
        tCP.sonuc.shouldHave(text(dogruladik));//condition dan import ettik,metnin sonuc elementinde icerdigini dogruladik
    // Assert.assertTrue(tCP.sonuc.getText().contains(dogruladik));// junit ile dogrulama

    }

    @And("switch to frame {int}")
    public void switchToFrame(int arg0) {
        switchTo().frame(arg0-1); // 1-1 = 0.index 1. iframe gider
    }

    @And("kullanici back to techproeducation.com linkine tiklar")
    public void kullaniciBackToTechproeducationComLinkineTiklar() throws InterruptedException {
        tCP.techProLink.click();
        System.out.println("techpro linkine tiklandi ve yeni pencere acildi");
        Thread.sleep(3000);
        System.out.println("sayfa url'i : "+url());// driver hala test page de

    }

    @And("switch to window {int}")
    public void switchToWindow(int hedefWindow) throws InterruptedException {
        switchTo().window(hedefWindow-1, Duration.ofSeconds(5));// index Duration zorunlu degil aslinda
        System.out.println("yeni pencereye gecis yapildi");
       Thread.sleep(3000);
        System.out.println("yeni sayfa url'i : "+url());//yeni sayfa url'i verecektir
    }
}
