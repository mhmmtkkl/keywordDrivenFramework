package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import keyWord.engineClass;

import java.util.List;

public class AllSteps {

    engineClass EngineClass = new engineClass();

    @Given("^\"([^\"]*)\" browser$")
    public void browser(String myAction) {

        EngineClass.browserActions(myAction);

    }

    @Given("^I am as a user entering field in \"([^\"]*)\" page$")
            public void i_am_as_a_user_entering_field_in_page(String sheetName, DataTable allData) {

                List<List<String>> valuesAndElementnames = allData.raw();

                for(int i = 0 ; i < valuesAndElementnames.size() ; i++){

                    String elementName = valuesAndElementnames.get(i).get(0);

                    String value = valuesAndElementnames.get(i).get(1);

            System.out.println(elementName);
            System.out.println(value);

            EngineClass.sendKeysFuntionality(elementName , value , sheetName);

        }


    }

    @Given("^I am as a user click on element in \"([^\"]*)\" page$")
    public void i_am_as_a_user_click_on_element_in_page(String sheetName, DataTable elementNames) {

        List<List<String>> allElements = elementNames.raw();

        for(int i = 0; i<allElements.size() ; i++){

            String elementName = allElements.get(i).get(0);

            EngineClass.clickFunctionality(elementName , sheetName);

        }




    }



}
