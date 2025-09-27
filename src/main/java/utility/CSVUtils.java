package utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVUtils {

    public static Iterator<User> readCSVData () {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/testdata/logindata.csv");
        FileReader fileReader = null;
        CSVReader csvReader;
        String[] line;
        List<User> list;

        try {
            fileReader = new FileReader(file);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();
             list= new ArrayList<>();
            while((line = csvReader.readNext())!=null) {
                User user = new User(line[0], line[1]);
                list.add(user);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
           catch (IOException e) {
               throw new RuntimeException(e);
           } catch (CsvValidationException e) {
               throw new RuntimeException(e);
           }
      return list.iterator();
    }
}
