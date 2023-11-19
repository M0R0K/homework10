package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class ResultPage {

    private SelenideElement resultCount = $("[data-marker='page-title/count']"),
            categoryAutoCurrent = $("[data-marker='category[1000014]/current']");

    public ResultPage availabilityOfSearchResults() {
        resultCount.shouldBe(Condition.visible);
        return this;
    }

    public ResultPage checkCategoryAutoCurrent(String value) {
        categoryAutoCurrent.shouldBe(Condition.visible);
        categoryAutoCurrent.shouldHave(Condition.text(value));
        return this;
    }


}



