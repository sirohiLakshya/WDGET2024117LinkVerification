import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class TestingURLS {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();

        List<String> toCheckList = new ArrayList<>();
        toCheckList.add("https://digitalsirohi.online/");

        while (!toCheckList.isEmpty()) {
            String currentURL = toCheckList.remove(0);

            driver.get(currentURL);

            List<WebElement> links = driver.findElements(By.tagName("a"));

            for (WebElement link : links) {
                String href = link.getAttribute("href");
                if (href != null && !href.isEmpty()) {
                    if (!toCheckList.contains(href)) {
                        toCheckList.add(href);
                    }
                }
            }


            URL currURL = new URL(currentURL);
            HttpURLConnection httpConn = (HttpURLConnection) currURL.openConnection();
            Thread.sleep(3000);

            int responseCode=0;
            try{
                httpConn.connect();
                responseCode = httpConn.getResponseCode();
            }catch(Exception e){
                System.out.println("This link is broken: " + currentURL);
            }
            if (responseCode >= 400) {
                System.out.println("This link is broken: " + currentURL);
            }
        }
        driver.quit();
    }
}
