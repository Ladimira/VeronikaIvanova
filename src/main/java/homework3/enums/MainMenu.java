package homework3.enums;

public enum MainMenu { HOME("Home"), CONTACT_FORM("Contact form"), SERVICE("Service"),
    METALS_COLORS("Metals & colors");

    MainMenu(String name) {
        this.name = name;
    }

    String name;
}
