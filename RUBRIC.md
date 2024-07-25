## Rubric for Task #23. Simple Login Test (100 Points)

### Project Setup (20 Points)
- Proper setup of IntelliJ IDEA project with Selenium and TestNG dependencies included in `pom.xml` or `build.gradle` (10 points)
- Correct structure and naming of the test class (`SimpleLoginTest`) (10 points)

### Test Implementation (50 Points)
- Correctly opening the website: https://magento.softwaretestingboard.com/ (10 points)
- Locating and interacting with the login elements (20 points)
  - Correctly identifying the username field and entering the provided username (5 points)
  - Correctly identifying the password field and entering the provided password (5 points)
  - Correctly identifying and clicking the submit button (10 points)
- Verifying successful login by checking for a specific post-login element (e.g., user profile link, welcome message) (20 points)

### Error Handling and Robustness (20 Points)
- Including error handling for incorrect login attempts (10 points)
- Handling any potential pop-ups or alerts to ensure the test runs smoothly without manual intervention (10 points)

### Submission (10 Points)
- Ensuring the test runs without errors (5 points)
- Pushing the project to the GitHub Classroom repository (5 points)

### Bonus Points (up to 20 Points)
- Creating additional login tests for other sites different from Magento (20 points)
  - Proper setup and execution of additional login tests for other websites (10 points per additional test, up to 2 additional tests)
