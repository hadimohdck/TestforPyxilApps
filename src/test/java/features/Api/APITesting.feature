@RunALLAPITests
Feature: API Testing test

  @Checkhealth
  Scenario Outline: Check health
    Given the test case id is <TestCaseID>
    When I hit the health check endpoint
    Then I verify the <status>

    Examples: 
      | TestCaseID | status |
      | TC01       |    200 |

  @Registeruser
  Scenario Outline: Register User
    Given the test case id is <TestCaseID>
    When I hit the endpoint with <username>,<email> and <password>
    Then registration returns <status>

    Examples: 
      | TestCaseID | username | email               | password   | status |
      | TC01       | myname   | myname1213@gmail.com | Myname@123 |    201 |
      | TC02       | myname   | myname              | Myname@123 |    400 |

  @LoginUser
  Scenario Outline: Login User
    Given the test case id is <TestCaseID>
    When user tries to login with <email> and <password>
    Then login returns <status>

    Examples: 
      | TestCaseID | email               | password   | status |
      | TC01       | myname123@gmail.com | Myname@123 |    200 |
      | TC02       | myname              | Myname@123 |    400 |
      | TC03       | myname@gmail.com    | Myname@124 |    401 |

  @Updateprofile
  Scenario Outline: Update Profile
    Given the test case id is <TestCaseID>
    When <validuser> provides <username>,<phone> and <company>
    Then update returns <status>

    Examples: 
      | TestCaseID | validuser | username | phone      | company | status |
      | TC01       | y         | myname   |   60476576 | diyar   |    200 |
      | TC02       | n         | myname   |   60476576 | diyar   |    401 |
      | TC03       | y         | myname   | wrongphone | diyar   |    400 |

  @Changepassword
  Scenario Outline: Update password
    Given the test case id is <TestCaseID>
    When <validuser> provides for changing password <oldpassword> and <newpassword>
    Then Change password returns <status>

    Examples: 
      | TestCaseID | validuser | oldpassword | newpassword | status |
      | TC01       | y         | Myname@1290 | Myname@1230 |    400 |
      | TC02       | y         | Myname@1230 | Myname@1231 |    200 |

  @CreateNote
  Scenario Outline: Creat note
    Given the test case id is <TestCaseID>
    When <validuser> provides  title : <title> for a note in category : <category> and with description:  <description>
    Then Creat note returns <status>

    Examples: 
      | TestCaseID | validuser | title     | description        | category | status |
      | TC01       | y         | NewTitle  | This is a new note | Home     |    200 |
      | TC02       | y         | NewTitle2 | This is a new note | Work     |    200 |
      | TC03       | y         | NewTitle3 | This is a new note | Personal |    200 |
      | TC04       | y         | NewTitle3 | This is a new note | Others   |    400 |
      | TC05       | n         | NewTitle3 | This is a new note | Others   |    401 |

  @UpdateNote
  Scenario Outline: Update a note
    Given the test case id is <TestCaseID>
    When <validuser> user updates a note with id : <id> title : <title> for a note in category : <category> , completed status : <completed_status> and with description:  <description>
    Then Update note returns <status>

    Examples: 
      | TestCaseID | validuser | id                       | title    | category | completed_status | description        | status |
      | TC01       | y         | 6749d87018b6cc015240757f | NewTitle | Home     | true             | This is a new note |    200 |
      | TC02       | y         | 6749d87018b6cc015240757f | NewTitle | Home     | invalid          | This is a new note |    400 |
      | TC03       | n         | 6749d87018b6cc015240757f | NewTitle | Home     | true             | This is a new note |    401 |

  @DeleteNote
  Scenario Outline: Delete a note
    Given the test case id is <TestCaseID>
    When <validuser> deletes a note with id : <id>
    Then Delete note returns <status>

    Examples: 
      | TestCaseID | validuser | id                       | status |
      | TC01       | y         | 674ab8a318b6cc01524077b6 |    200 |
      | TC02       | n         | 674ab8a318b6cc01524077b6 |    401 |
      | TC03       | y         | invalid123               |    400 |
