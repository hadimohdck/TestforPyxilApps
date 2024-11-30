Greetings Reader!

Here is a quick guide on how to run the tests in the frame work I have built : 

I have used a BDD Cucumber framework that covers both the selenium and API automated tests
You will find two sets of feature files in below location :
 
The feature files under API covers the tests for the API testing and the one’s under Web covers the web testing
The feature files have tags on them which can be used to run the tests
 
For APIs I have used different tags for different endpoints so that they can be run individually if needed :
 

To run the tests all you need to do is copy the tagname, for example : to run all the API tests copy the tag @RunALLAPITests and paste it under tags in the TestNGRunner_API 
 









Place it inside tags – inside cucumber options
 
Now all you need to run is to run this runner file and the tests will execute.
Once run is completed , you will find the extent report here – Spark.html – open it in a browser to view the report for you run : 

 








Report will look as follows: 
 
Now to run the web tests, copy the tagname from the features for web , for example : @placeEcommerceOrder
 
Now place this tag inside the testrunner for web
 
Now run this file to run all the web tests.
Once your run is complete you can find the report same as for API. But if you need a more comprehensive report with screenshots for failures, you can find it here : 
 

Search for your timestamp to open your report. It will look like this:
 
Currently I have configured tests to provide screenshots for only failed tests. This can however be customized according to user needs.


There is of course a lot of scope for additional enhancements for these tests created. However, since I have the constrain of time, I have tried to include as many features as I could. I hope we get to discuss further.

Thank you for your time and hoping to hear from you soon.
Hadi Mohamed.

