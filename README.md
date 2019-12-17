# PropellerAds Automated Testing Championship
**Project Tech Stack:** Java, Selenide, TestNG, Maven, ReportNG

### Task for Championship:
Docker container is used for application launch, use the following command to run it:  
**docker run -d -p 8080:8080 qapropeller/qa-battle:latest**  
After running this command, the application will be available by the following link: **http://localhost:8080**  
Valid credentials to sign in to application:  
**login:** test  
**password:** test

More detailed information can be found here:   
https://hub.docker.com/repository/docker/qapropeller/qa-battle


## To run tests in various modes use the following commands:
| Mode | Command |
| --- | --- |
| **Chrome visible** | mvn clean test |
| **Chrome headless** | mvn clean test -Dselenide.headless=true |
| **Firefox visible** | mvn clean test -Dselenide.browser=firefox |
| **Firefox headless** | mvn clean test -Dselenide.browser=firefox -Dselenide.headless=true |


### Reports:
**html reports** with detailed logging for all tests and screenshots for failed tests are taken after each test run. They can be found in **/test-output** directory


### Summaries of some found bugs:
1) articleDataFileTextLink for Tim Cook article is wrong. Actual: "data/tim_cook/tim_cook.txt", Expected: "tim_cook/tim_cook_file_data.txt"
2) loader time for Tim Cook is too long: 1000000ms
3) text for Youtube article on the page and in downloaded file mismatch (this is catched by autotests)
4) text for Sasha Grey article on the page and in downloaded file mismatch (this is catched by autotests)
5) can't dowload file for Tony Stark article, because  /data/tony_stark/tony_stark_file_data.txt response status is 404 Not Found (this is catched by autotests indirectly)
6) some text misspellings across website: "Welcom" in title of the Login page, "Leonel Messi" in article about Lionel Messi
