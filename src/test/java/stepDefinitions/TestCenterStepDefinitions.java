package stepDefinitions;


import com.codeborne.selenide.Condition;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.TestCenterPages;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;

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
        if(text.equals("Checkbox 1")  && !tCP.checkbox1.isSelected()){
            tCP.checkbox1.click();
         //   Assert.assertTrue(tCP.checkbox1.isSelected());  Junit assertion
         //   tCP.checkbox1.shouldBe(Condition.checked); //selenide uzun
            tCP.checkbox1.shouldBe(checked);
        }
        if(text.equals("Checkbox 2") && !tCP.checkbox2.isSelected()){
            tCP.checkbox2.shouldNotBe(checked);//secili degilse
        tCP.checkbox2.click();
        tCP.checkbox2.shouldBe(checked);
        }

        if (text.equals("Red") && !tCP.red.isSelected()){
            tCP.red.shouldNotBe(checked);//secili olmadigini test ediyoruz ama zaten if icinde yazmistik
            tCP.red.click();//sec
            tCP.red.shouldBe(checked);//secili oldugunu test et
        }

        if (text.equals("Football") && !tCP.football.isSelected()){
            tCP.football.click();
            tCP.football.shouldBe(checked);
        }
    }



}
