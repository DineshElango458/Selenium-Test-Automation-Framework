package pojo;

import lombok.Data;

@Data
public class Environment {
    private String url;
    private String MAX_ATTEMPT;
    private String CURRENT_ATTEMPT;

}
