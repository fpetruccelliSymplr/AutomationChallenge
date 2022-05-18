package pages;

public class GooglePage extends BasePage {

    private final String searchButton = "//div[@class= 'FPdoLc lJ9FBc']//input[@name= 'btnK'] ";
    private final String searchInput = "//input[@name= 'q']";

    public GooglePage() {
        super(driver);
    }

    public void navigateToGoogle() {
        navigateTo("https://www.google.com/");
    }

    public void clickSearchButton() {
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria) {
        sendText(searchInput, criteria);
    }
}
