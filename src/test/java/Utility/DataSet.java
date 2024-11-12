package Utility;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "validCredentials")
    public static Object ValidCredentials(){
        Object[][] data = {
                {"01714536194", "Book@12345"}
        };
        return data;
    }
}
