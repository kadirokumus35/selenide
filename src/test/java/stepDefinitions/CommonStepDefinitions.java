package stepDefinitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.*;

import static com.codeborne.selenide.Selenide.*;

public class CommonStepDefinitions {

    @Given("kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String string) {

        open(string);

    }

    @Given("{int} saniye bekler")
    public void saniye_bekler(Integer int1) {
       sleep(int1*1000);
    }

    @Then("onceki sayfaya gider")
    public void onceki_sayfaya_gider() {
        back();

    }
    @Then("sonraki sayfaya gider")
    public void sonraki_sayfaya_gider() {
        forward();
    }
    @Then("sayfayi yeniler")
    public void sayfayi_yeniler() {
        refresh();
    }
    @Then("sayfayi acik tutar")
    public void sayfayi_acik_tutar() {
//varsayilan Selenide ayarlarinda browser oto kapanir
       // Configuration.holdBrowserOpen=false; varsayilan
        Configuration.holdBrowserOpen=true; // amac pass olup olmadigini gormek, sayfa acik kalsin

    }


}
