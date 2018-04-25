package Tests;

import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class GoogleTest extends TestBase {

    @Test
    public void googletest(){
        initialization();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Log in to continue - Log in with Atlassian account");
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
