@SmokeTest
  Feature: Singing in the website

    Scenario Outline: Sign in to website

#      all the browser actions will be handling in this step
      Given "Open" browser

#      All send keys functionality I need to use this text and give element name in the excel and value which I want to type
      And I am as a user entering field in "login" page
      |username|makoklu32@gmail.com|
      |password|China1949        |

      And I am as a user click on element in "login" page
      |loginButton|

      And I am as a user click on element in "HomePage" page
      |serviceDropdown|
      |ticketInDropdown|

      And I am as a user click on element in "Tickets" page
      | CreateTicket|

      And I am as a user entering field in "Tickets" page
      |TicketName|myTicketIsHere|

      And I am as a user click on element in "Tickets" page
      |TicketStatusDropdown|
      | <DifferentStatusForTicket>    |

      Then "quit" browser

      Examples:
        | DifferentStatusForTicket |
        |   OptionNew             |
#        |   OptionWaitingOnUS   |
#        |   OptionWaitingOnContact |
#        |   OptionClosed           |


#     I have a custom gherkin language
#     If we are creating the feature file then we can use this framework
#     if BA or PO creating the feature file then we can  not.


