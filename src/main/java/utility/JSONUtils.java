package utility;

import com.google.gson.Gson;
import pojo.Config;
import pojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class JSONUtils {
    private static final String USER_DIR = System.getProperty("user.dir");

   public static Environment readJSON() {

       Gson gson = new Gson(); // for reading json file
       File FILE = new File(USER_DIR + "/src/test/resources/config/config.json");
       FileReader fileReader = null;
       try {
           fileReader = new FileReader(FILE);
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       }
       Config config = gson.fromJson(fileReader, Config.class);
       Map<String, Environment> environments = config.getEnvironments();
       Environment environment = environments.get("QA");
       return environment;
   }
}
