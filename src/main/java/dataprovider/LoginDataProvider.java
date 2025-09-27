package dataprovider;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import pojo.LoginData;
import pojo.User;
import utility.CSVUtils;
import utility.ExcelReaderUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {
    private static final String USER_DIR = System.getProperty("user.dir");

    @DataProvider(name = "logindata")
    public Iterator<Object[]> logindataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        File file = new File(USER_DIR + "/src/test/resources/config/logintestdata.json");
        FileReader fileReader = new FileReader(file);
        LoginData loginData = gson.fromJson(fileReader, LoginData.class);

        List<Object[]> data = new ArrayList<>();

        for (User userdata : loginData.getData()) {
            data.add(new Object[]{userdata});
        }
        return data.iterator();
    }
@DataProvider(name = "LoginDataUsingCSV",parallel = false)
    public Iterator<User> loginCSVDataProvider() {
        return CSVUtils.readCSVData();
    }

    @DataProvider(name = "LoginDataUsingExcel",parallel = false)
    public Iterator<User> loginExcelDataProvider() {
        return ExcelReaderUtility.readExcelData();
    }
}
