package utilities;

import org.openqa.selenium.WebDriver;

public class Driver {

    /*
        Singleton driver

         I was calling this driver from multiple pages and it should be static

        ------

        this framework driver is non static

        Because we are calling the driver from one class which is keywordEngine. Basically we are not moving from one class to other like in POM

     */

    WebDriver driver;

    public WebDriver getDriver(){

        if(getPropeties.equals("browser").equals("Chrome")){



        }

        return driver;
    }





}
