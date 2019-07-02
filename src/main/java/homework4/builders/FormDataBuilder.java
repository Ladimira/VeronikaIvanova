package homework4.builders;

import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Builder
@Getter
public class FormDataBuilder {
    public String summaryRadio1;
    public String summaryRadio2;
    public List<String> elements;
    public String color;
    public String metal;
    public List<String> vegetables;
}
