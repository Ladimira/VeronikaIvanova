package homework3.enums;

// TODO Please follow Java Code convention for class structure
// TODO You could press CTRL + Alt + L in IDEA for this format
public enum MainMenu { HOME("Home"), CONTACT_FORM("Contact form"), SERVICE("Service"),
    METALS_COLORS("Metals & colors");

    MainMenu(String name) {
        this.name = name;
    }

    String name;
}
