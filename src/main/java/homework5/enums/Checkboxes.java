package homework5.enums;

// TODO Please follow Java Code convention for class structure
// TODO You could press CTRL + Alt + L in IDEA for this format
public enum Checkboxes {
    WATER("Water"), WIND("Wind"), FIRE("Fire"), EARTH("Earth");
    String name;

    Checkboxes(String name) {
        this.name = name;
    }
}
