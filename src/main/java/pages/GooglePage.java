package pages;

public class GooglePage extends BasePage {

    private final String searchButton = "//div[@class= 'FPdoLc lJ9FBc']//input[@name= 'btnK'] ";

    public GooglePage() {
        super(driver);
    }

    public void navigateToGoogle() {
        navigateTo("https://www.google.com/");
    }

    public void clickSearchButton() {
        clickElement(searchButton);
    }
}
