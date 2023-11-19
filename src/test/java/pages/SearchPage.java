package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {


    private SelenideElement searchInput = $("[data-marker='search-form/suggest']"),
            searchButton = $("[data-marker='search-form/submit-button']");

    public SearchPage fillSearchInput(String value) {
        searchInput.setValue(value);
        return this;
    }

    public SearchPage clickSearch() {
        searchButton.click();
        return this;
    }

    public SearchPage openPage() {
        open("");
        return this;
    }


}


