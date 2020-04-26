package keyWord;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.ReadProperty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class engineClass {

    public WebDriver driver;

    Driver d1 = new Driver();
    ReadProperty rp1 = new ReadProperty();

    String elementFilePath = "C:\\Users\\JuNiOr\\IdeaProjects\\KeywordDrivernWithClassApril25\\src\\main\\java\\AllElements\\keywordDriverLocators.xlsx";

    public WebElement findingElementMethod(String sheetName , String elementName){

        WebElement resultElement = null;

        FileInputStream inputStream = null ;
        Workbook book = null;
        Sheet sheet = null;

        try {
            inputStream = new FileInputStream(elementFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);

        String locatorType = null;
        String locatorValue = null;


//        finding the locator type and locator value from the excel
        for(int i = 0 ; i < sheet.getLastRowNum() ; i++){

            String elementNameFromExcel = sheet.getRow(i+1).getCell(0).toString().trim();

            if(elementNameFromExcel.equalsIgnoreCase(elementName)){

                locatorType = sheet.getRow(i+1).getCell(1).toString().trim();
                locatorValue = sheet.getRow(i+1).getCell(2).toString().trim();
                break;
            }

        }

//        using locator type to create a web element
        switch(locatorType){

            case"id":
                resultElement = driver.findElement(By.id(locatorValue));
                break;

            case"xpath":
                resultElement = driver.findElement(By.xpath(locatorValue));
                break;

            case"cssSelector":
                resultElement = driver.findElement(By.cssSelector(locatorValue));
                break;
        }


        return resultElement;
    }

    public void sendKeysFuntionality(String elementName , String value , String sheetName){

        WebElement sendkeyElement = findingElementMethod(sheetName , elementName);

        sendkeyElement.sendKeys(value);

    }

    public void clickFunctionality(String ElementName , String sheetName){

        WebElement clickElement = findingElementMethod(sheetName , ElementName);

        clickElement.click();

    }


    public void browserActions(String whichAction){

        switch (whichAction){

            case "Open":
            driver = d1.getDriver();
            driver.get(rp1.getData("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            break;

            case "quit":
                driver.quit();
                break;

            case "close":
                driver.close();
                break;


        }



    }



}
