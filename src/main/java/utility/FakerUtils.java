package utility;

import com.github.javafaker.Faker;
import pojo.AddressPojo;

public class FakerUtils {

    public static AddressPojo generateFakerData() {
        // Implementation for generating fake data
        Faker faker = new Faker();
         AddressPojo addressPojo = new AddressPojo(faker.name().firstName(), faker.address().buildingNumber(), faker.address().streetAddress(), faker.address().city(), faker.address().state(), faker.numerify("#####"), faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "This is my address", "Office Address");
         return addressPojo;
    }
}
