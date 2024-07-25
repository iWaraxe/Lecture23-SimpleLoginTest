# Task 23. Simple Login Test

## Task Description

Using Selenium and TestNG technologies, write a simple login test for the website [Magento Software Testing Board](https://magento.softwaretestingboard.com/), using the following credentials:

- **Username:** selenium.tester@gmail.com
- **Password:** qyq*nbp.zcw2apq4ZQW

## Project Setup

This task is accompanied by an IntelliJ IDEA project placed on GitHub Classroom. Ensure you have the necessary dependencies for Selenium and TestNG in your `pom.xml` or `build.gradle` file.

### Steps to Follow:

1. **Create a New Test Class:**
    - Name the class `SimpleLoginTest`.
    - Use the appropriate annotations from TestNG.

2. **Write the Login Test:**
    - Open the website: https://magento.softwaretestingboard.com/
    - Locate the login elements on the page.
    - Enter the provided username and password.
    - Submit the login form.
    - Verify successful login by checking for a specific element that appears only when logged in (e.g., a user profile link or a welcome message).

3. **Handle Potential Issues:**
    - Include error handling for incorrect login attempts.
    - Ensure your test can run smoothly without manual intervention by handling any potential pop-ups or alerts.

4. **Bonus Task:**
    - Create additional login tests for other websites different from Magento.
    - Ensure proper setup and execution of these additional login tests.

## Submission

- Ensure your test runs without errors.
- Push your project to the GitHub Classroom repository.
