# Testing URLs with Selenium

## Overview
This Java program utilizes Selenium WebDriver to automate the testing of URLs by checking for broken links on a given website. The script iterates through all the links on a webpage, verifies their validity, and reports any broken links encountered during the process.

## Objective
The main objective of this code is to perform automated testing of URLs to ensure their integrity and functionality. By systematically checking each link on a webpage, the script aims to identify any broken links that may lead to error pages or inaccessible content.

## How It Works
1. **Setup WebDriver:** The code initializes a Chrome WebDriver instance using Selenium. This WebDriver is responsible for simulating user interactions with the Chrome browser.
   
2. **Define Initial URL:** The URL to be tested is added to a list called `toCheckList`. This list serves as a queue to store URLs that need to be checked.

3. **Iterate Through URLs:**
   - The code enters a while loop that continues until all URLs in the `toCheckList` have been checked.
   - Inside the loop, the first URL from the list is removed and assigned to the variable `currentURL`.
   
4. **Retrieve Webpage:** Selenium WebDriver navigates to the `currentURL` to access the webpage.

5. **Find Links:**
   - The code locates all anchor elements (`<a>` tags) on the webpage using Selenium's `findElements` method.
   - Each link's URL (`href` attribute) is extracted and added to the `toCheckList` if it is not already present, ensuring that all links on the page will be checked recursively.

6. **Check Link Status:**
   - The code establishes an HTTP connection to the `currentURL` using Java's `HttpURLConnection` class.
   - After a brief delay (3000 milliseconds), the script attempts to retrieve the HTTP response code.
   - If the response code is greater than or equal to 400, it indicates a broken link, and an error message is printed.

7. **Cleanup:**
   - Once all URLs have been checked, the WebDriver instance is closed to release system resources.

## Usage
1. Ensure that you are using a Selenium version that comes with Selenium Webdriver manager or ensure ChromeDriver is installed and its path is properly configured
2. Run the `main` method of the `TestingURLS` class.
3. Monitor the console output for any messages indicating broken links.

