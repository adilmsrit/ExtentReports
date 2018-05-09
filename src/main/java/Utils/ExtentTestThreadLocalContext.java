package Utils;

import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestThreadLocalContext {
    private static final ThreadLocal<ExtentTest> EXTENT_TEST_THREAD_LOCAL = new ThreadLocal<ExtentTest>();

    public static void setExtentText(ExtentTest extentTest){
        EXTENT_TEST_THREAD_LOCAL.set(extentTest);
    }
    public static ExtentTest getExtentTest(){
        return EXTENT_TEST_THREAD_LOCAL.get();
    }
    public static void remove(){
        EXTENT_TEST_THREAD_LOCAL.remove();
    }
}
