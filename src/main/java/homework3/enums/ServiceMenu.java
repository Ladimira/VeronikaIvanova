package homework3.enums;

public enum ServiceMenu {
    SUPPORT("Support"), DATES("Dates"), COMPLEX_TABLE("Complex Table"), SIMPLE_TABLE("Simple Table"),
    TABLE_WITH_PAGES("Table with pages"), DIFFERENT_ELEMENTS("Different elements");

    ServiceMenu(String name) {
        this.name = name;
    }

    String name;
}
