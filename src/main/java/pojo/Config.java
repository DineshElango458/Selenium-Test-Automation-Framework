package pojo;

import lombok.Data;

import java.util.Map;
@Data
public class Config {
    private Map<String, Environment> environments;

}
