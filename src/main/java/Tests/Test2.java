package Tests;

import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test2 extends TestBase {

    @Test
    public void googletest(){
        initialization();
        String title = driver.getTitle();
        Assert.assertEquals(title, " in with Atlassian account");
    }

    @AfterTest
    public void teardown(){
        driver.quit();
        extentReports.flush();
		//extentReports.close();
    }
}
