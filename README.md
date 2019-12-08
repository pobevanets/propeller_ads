# PropellerAds Automated Testing Championship
Project Tech Stack: Java, Selenide, TestNG, Maven, ReportNG

To run tests use the following command
1) visible mode: 
$ mvn clean test 
2) headless mode: 
$ mvn clean test -Dselenide.headless=true

Besides, html reports with detailed logging for all tests and screenshots for failed tests are taken after each test run. They can be found in /test-output directory

Sorry, I have no time to create bug reports, but here summaries of some found bugs:
1) seems that articleDataFileTextLink for Tim Cook article is wrong. Actual: "data/tim_cook/tim_cook.txt", Expected: "tim_cook/tim_cook_file_data.txt"
2) loader time for Tim Cook is too long: 1000000ms
3) text for Youtube article on the page and in downloaded file mismatch (this is catched by autotests)
4) text for Sasha Grey article on the page and in downloaded file mismatch (this is catched by autotests)
5) can't dowload file for Tony Stark article, because  /data/tony_stark/tony_stark_file_data.txt response status is 404 Not Found (this is catched by autotests indirectly)
6) some text misspellings across website: "Welcom" in title of the Login page, "Leonel Messi" in article about Lionel Messi
