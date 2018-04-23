package Tests;

import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends TestBase {

    @Test
    public void googletest(){
        initialization();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");
    }

}
