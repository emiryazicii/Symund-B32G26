package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FilesPage extends BasePage {

    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusDropdown;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadFileLink;

    @FindBy(xpath = "//a[@data-templatename='New folder']")
    public WebElement newFolderLink;

    @FindBy(xpath = "//input[@value='New folder']")
    public WebElement inputNewFolderName;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement arrowButton;

    @FindBy(xpath = "//a[@data-action='Delete']")
    public WebElement deleteFolderOption;

    @FindBy(xpath = "//a[.='Deleted files']")
    public WebElement deletedFilesFoldersLink;

    @FindBy(xpath = "(//span[@class='nametext extra-data']/span[.='Boris'])[1]")
    public WebElement fileFolderDeleted;

    @FindBy(xpath = "//tfoot//span/span[text()='2 folders']")
    private WebElement totalNumberOfFolders;

    @FindBy(xpath = "//tfoot//span/span[text()='2 folders']/following-sibling::span[2]")
    private WebElement totalNumberOfFiles;

    @FindBy(css = ".innernametext")
    public List<WebElement> listOfAllFilesAndFolders;

    @FindBy(xpath = "(//tbody)[1]/tr[@data-type='dir']")
    private List<WebElement> folderInfo;

    @FindBy(xpath = "(//tbody)[1]/tr[@data-type='file']")
    private List<WebElement> fileInfo;


    /**
     * This method loop through list of web elements and get text from them, and compare with expected text,and return boolean
     * @param listOfWebelements
     * @param expectedText
     * @return boolean
     */
    public boolean isExpectedNameInListOfFiles(List<WebElement> listOfWebelements, String expectedText) {
        BrowserUtils.waitFor(2);
        List<String> allElemetsText = BrowserUtils.getElementsText(listOfWebelements);
        for (String eachText : allElemetsText) {
            if (eachText.equalsIgnoreCase(expectedText)) {
                return true;
            }

        }

        return false;
    }

    /**
     * This method concatenate each computer local directory with file path of file we want to use and create absolute path
     * @return String fullPathName
     */
    public String getFullPath() {
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/test_files/Cydeo.txt";
        String fullPath = projectPath + "/" + filePath;
        return fullPath;
    }

    /**
     * This method clicks on web element,with provided fileName and provide us additional options
     * @param fileName
     */
    public void clickOnThreeDotsNearSelectedFileOrFolder(String fileName) {
        WebElement threeDots = Driver.getDriver().findElement(By.xpath("(//tbody/tr[@data-file='" + fileName + "']//a)[3]"));

        threeDots.click();
    }


    /**
     * This method get value from web element, and compare it with expected value and returns boolean
     * @return boolean
     */
    public boolean isNumberOfFoldersAndFilesEqual(){
        String numberOfFolders = String.valueOf(folderInfo.size());
        String numberOfFiles = String.valueOf(fileInfo.size());
        if(totalNumberOfFolders.getText().contains(numberOfFolders) && totalNumberOfFiles.getText().contains(numberOfFiles)){
            return true;
        }
        return false;

    }





                //****************Abe's part*********************************


    @FindBy(xpath = "//a[@class='name']/span/span[.='Hello World']/../following-sibling::span/a[@class='action action-menu permanent']")
    private WebElement threeDots;


    @FindBy(xpath = "//div/ul/li/a[@class='menuitem action action-favorite permanent']")
    private WebElement addToFavorites;


    @FindBy(xpath = "//div[@id='app-navigation']/ul/li/a[@class='nav-icon-favorites svg']")
    private WebElement favoritePage;


    @FindBy(xpath = "//td[@class='filename']/a/span/span[.='Hello World']")
    private WebElement fileOnFavoritePage;


    @FindBy(xpath = "//div/ul/li/a[@class='menuitem action action-details permanent']")
    private WebElement detailsFile;

    @FindBy(xpath = "//div/ul/li/a[@class='menuitem action action-rename permanent']")
    private WebElement renameFile;

    @FindBy(xpath = "//a[@id='comments']")
    private WebElement commentsButton;

    @FindBy(xpath = "//div[@placeholder='Write message, @ to mention someone …']")
    private WebElement commentsSection;

    Actions action = new Actions(Driver.getDriver());




    public void clickOnThreeDots(){
        threeDots.click();
    }
    public void clickOnAddToFavorites(){
        addToFavorites.click();
    }


    public void checkIfFileDisplayed(){
        favoritePage.click();
        fileOnFavoritePage.isDisplayed();
    }



    public void renameFileName(String fileName, String renamedFile){
        WebElement threeDotButton = Driver.getDriver().findElement(
                By.xpath("//a[@class='name']/span/span[.='"+fileName+"']/../following-sibling::span/a[@class='action action-menu permanent']"));
        threeDotButton.click();
        renameFile.click();
        action.sendKeys(Keys.BACK_SPACE).sendKeys(renamedFile).sendKeys(Keys.ENTER).perform();
        BrowserUtils.waitFor(3);
    }


    public boolean isFileNameUpdated(String updatedFileName){
        WebElement renamedFile = Driver.getDriver().findElement
                (By.xpath("//td/a[@class='name']/div/following-sibling::span/span[.='"+updatedFileName+"']"));
        BrowserUtils.waitFor(2);

        return renamedFile.isDisplayed();
    }

    public void detailsFile(String fileName){
        WebElement threeDotButton = Driver.getDriver().findElement(
                By.xpath("//a[@class='name']/span/span[.='"+fileName+"']/../following-sibling::span/a[@class='action action-menu permanent']"));
        threeDotButton.click();
        detailsFile.click();

    }

    public void clickOnCommentButton(){
        commentsButton.click();
    }

    public void addCommentUnderFile(String comment){
        commentsSection.click();
        action.sendKeys(comment).sendKeys(Keys.ENTER).perform();

    }

    public boolean isCommentAdded(String comment){
        WebElement addedComment = Driver.getDriver().findElement(By.xpath("//div/div[.='"+comment+"']"));
        BrowserUtils.waitFor(2);

    return addedComment.isDisplayed();
    }

}


