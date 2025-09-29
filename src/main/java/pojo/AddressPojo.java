package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressPojo {
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalCode;
    private String homePhone;
    private String mobilePhone;
    private String otherInfo;
    private String addressalias;
}
