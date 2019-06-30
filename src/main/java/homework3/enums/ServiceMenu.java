package homework3.enums;

// TODO Please follow Java Code convention for class structure
// TODO You could press CTRL + Alt + L in IDEA for this format
public enum ServiceMenu {
    SUPPORT("Support"), DATES("Dates"), COMPLEX_TABLE("Complex Table"), SIMPLE_TABLE("Simple Table"),
    TABLE_WITH_PAGES("Table with pages"), DIFFERENT_ELEMENTS("Different elements");

    ServiceMenu(String name) {
        this.name = name;
    }

    String name;
}
