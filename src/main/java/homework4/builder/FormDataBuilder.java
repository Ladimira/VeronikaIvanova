package homework4.builder;

import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Getter
public class FormDataBuilder {
    private String summaryRadio1;
    private String summaryRadio2;
    private List<String> elements;
    private String color;
    private String metal;
    private List<String> vegetables;

    @Builder
    public FormDataBuilder(String summaryRadio1, String summaryRadio2, List<String> elements,String color, String metal,
                                         List<String> vegetables){
        this.summaryRadio1 = summaryRadio1;
        this.summaryRadio2 = summaryRadio2;
        this.elements = elements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;

    }
}
