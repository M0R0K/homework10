package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.ResultPage;
import pages.SearchPage;

@DisplayName("Тесты на проверку популярных моделей в поиске")
public class SearchTestsCurrentFilter extends TestBase {

    ResultPage resultPage = new ResultPage();
    SearchPage searchPage = new SearchPage();

    String category = "Автомобили";

    @ValueSource(strings = {
            "Lada",
            "Ford"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} в результате фильтр выбирает категорию 'Автомобили' и делает ее текущей")
    void checkCurrentFilterValueSource(String value) {

        searchPage.openPage().fillSearchInput(value).clickSearch();
        resultPage.availabilityOfSearchResults().checkCategoryAutoCurrent(category);
    }


    @CsvSource(value = {
            "Kia , Автомобили",
            "Subaru , Автомобили"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} в результате фильтр выбирает категорию {1} и делает ее текущей")
    void checkCurrentFilterCsvSource(String value, String category) {
        searchPage.openPage().fillSearchInput(value).clickSearch();
        resultPage.availabilityOfSearchResults().checkCategoryAutoCurrent(category);
    }

    @CsvFileSource(resources = "/test_data/searchData.csv")
    @ParameterizedTest(name = "Для поискового запроса {0} в результате фильтр выбирает категорию {1} и делает ее текущей")
    void checkCurrentFilterCsvFile(String value, String category) {
        searchPage.openPage().fillSearchInput(value).clickSearch();
        resultPage.availabilityOfSearchResults().checkCategoryAutoCurrent(category);
    }
}
