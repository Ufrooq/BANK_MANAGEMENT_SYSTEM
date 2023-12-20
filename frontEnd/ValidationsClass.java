
import java.time.LocalDate;

public class ValidationsClass {
    public boolean checkString(String value) {
        if (value.matches("[a-zA-Z ]*"))
            return false;
        else {
            return true;
        }

    }

    public boolean checkNumber(String value) {
        if (value.matches("[0-9]*"))
            return false;
        else
            return true;
    }

    public boolean checkGender(String value) {
        if (value.equalsIgnoreCase("male") || value.equalsIgnoreCase(("female"))) {
            return false;
        } else
            return true;
    }

    public boolean checkAge(String value) {
        int age = Integer.parseInt(value);
        if (age >= 18 && age <= 70) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkDay(String value) {
        int day = Integer.parseInt(value);
        if (day > 0 && day <= 31) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkMonth(String value) {
        int month = Integer.parseInt(value);
        if (month > 0 && month <= 12)
            return false;
        else
            return true;
    }

    public boolean checkYear(String value) {
        LocalDate d1 = LocalDate.now();
        int year = Integer.parseInt(value);
        if (year < d1.getYear())
            return false;
        else
            return true;
    }
}
