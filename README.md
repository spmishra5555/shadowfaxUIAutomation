This is a gradle project.

Version of chrome driver which has been used here - 
- chromedriver.exe - ChromeDriver 81.0.4044.69
- chrome browser version - Version 81.0.4044.92
- selenium webdriver version - Versioin 3.141.59
- For reporting purpose have used Allure Reports which has been used to attach screenshot as well

Note - Also, before executing the test plz update inputData.properties file
which contains keys for username and password since I have used mine(personal) and can't share it

File name - inputData.properties
Keys - mobile.number=<your mobile number>
       password=<your password>

Steps to execute - 
1. ./gradlew clean build

2. For checking allure report - 
   ./gradlew allureServe
   
The use cases which has been taken into consideration - 
1. Since flipkart is selling only essentials hence the program is only till add to cart screen.
2. Item which has been used here - OPPO A3s (Purple, 16 GB)

Note - I thought of using essentials but since lockdown has been extended till 3rd May hence almost all items are going
out of stock or not for delivery error is coming.Hence continued my automation for the give case only
 