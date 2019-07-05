package homework5.enums;

// TODO Please follow Java Code convention for class structure
// TODO You could press CTRL + Alt + L in IDEA for this format : done
public enum ServiceMenu {
    SUPPORT("Support"), DATES("Dates"), SEARCH("Search"), COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"), USER_TABLE("User table"), TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"), PERFORMANCE("Performance");

    String name;

    ServiceMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
