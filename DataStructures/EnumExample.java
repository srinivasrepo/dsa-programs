package DataStructures;

import java.util.Arrays;

/**
 * <pre>
 * public enum must be in a own file, and so we can have n number of default enums in a file
 * </pre>
 *
 * @author Srinivas Vadige
 * @since 17 Oct 2024
 *
 */

public class EnumExample {

    @SuppressWarnings("unlikely-arg-type")
    public static void main(String[] args) {

        // WeekDay enum
        System.out.println("WeekDay enum ----------------");
        WeekDay dayEnum = WeekDay.MONDAY;
        String day1 = WeekDay.MONDAY.name(); // built-in final static method, same as toSting()
        WeekDay day1Enum = WeekDay.valueOf(day1); // throws IllegalArgumentException if the value is not in the enum
        day1Enum = WeekDay.valueOf("MONDAY"); // built-in final static method & same as above
        String day2 = WeekDay.MONDAY.toString(); // built-in non-final static & can be @Override as shown inside the WeekDay enum
        int dayIndex = WeekDay.MONDAY.ordinal(); // built-in final static method for index
        WeekDay[] days = WeekDay.values(); // built-in final static method
        Object decClass = day1Enum.getDeclaringClass(); // returns the class of the enum

        System.out.println(WeekDay.SUNDAY);
        System.out.println(WeekDay.MONDAY.equals(day1)); // false because day1 is a string but .equals(Object param)
        System.out.println(WeekDay.MONDAY.equals(day1Enum)); // true always compare enum to enum or string to string
        System.out.println(WeekDay.MONDAY.name().equals(day1)); // true as we compare string to string
        System.out.println(dayEnum);
        System.out.println(day1);
        System.out.println(day1Enum);
        System.out.println(day2);
        System.out.println(dayIndex);
        System.out.println(days);
        System.out.println(decClass);

        // Roman enum
        System.out.println("Roman enum ----------------");
        Roman romanEnum = Roman.I;
        romanEnum = Roman.valueOf("I");
        System.out.println(romanEnum);
        // System.out.println(romanEnum.value); --- if value variable is not private
        System.out.println(romanEnum.getValue());
        System.out.println(Roman.valueOf("L"));
        System.out.println(Roman.valueOf("D").getValue()); // java.lang.IllegalArgumentException if we use small "d", i.e enum is case sensitive
        System.out.println(Arrays.toString(Roman.values())); // .values() is a built-in final static method

        // Frequency enum
        System.out.println("Frequency enum ----------------");
        String frequency = "Every Week";
        Frequency freqEnum = Frequency.WEEKLY; // by default a constructor initializes the EVERY WEEK enum and all the static methods can be used
        System.out.println(Frequency.isFrequency(frequency));
        System.out.println(Frequency.toCode(frequency));
        System.out.println(Frequency.getValueByDisplayName(frequency));
        System.out.println(freqEnum.getDisplayName());
        System.out.println(freqEnum.getCode());
        System.out.println(freqEnum.name());
        System.out.println(freqEnum.ordinal());
    }
}

// default standard enum
enum WeekDay {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}

// enum with private constructor (with 1 parameter)
enum Roman {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

    private int value; // private param can only be accessed by getter i.e getValue()

    Roman(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

// enum with private constructor (with 2 parameters) and public static methods
enum Frequency {

    ONCE("Once", "1"), // code can be String or int but we still have the ordinal() built-in static method
    WEEKLY("Every Week", "2"),
    EVERY_TWO_WEEKS("Every Two Weeks", "3"),
    EVERY_FIRST_AND_FIFTEENTH("Every 1st and 15th of the Month", "4"),
    MONTHLY("Monthly", "5"),
    EVERY_TWO_MONTHS("Every Two Months", "6"),
    QUARTERLY("Quarterly", "7"),
    SEMI_ANNUALLY("Semi-Annually", "8"),
    ANNUALLY("Annually", "9");

    final String displayName; // final because it is initialized in the constructor and cannot be changed
    final String code;

    public String getDisplayName() {
        return displayName;
    }

    public String getCode() {
        return code;

    }

    // enum constructor is always a private by default because -> Frequency foo = new Frequency("new day","44"); will not work like class
    Frequency(String displayName, String code) {
        this.displayName = displayName;
        this.code = code;
    }

    public static boolean isFrequency(String frequency) {
        try {
            Frequency.valueOf(frequency);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static String toCode(String frequency) {
        try {
            return Frequency.valueOf(frequency).code;
        } catch (IllegalArgumentException e) {
            System.out.println("Unable to map requested frequency " + frequency + " to field value");
        }
        return "N/A";
        // throw new FrequencyMappingException("Unable to map requested frequency " + frequency + to field value.") ");
    }

    // this will fail for Semi-Annually because of "-" in the display name, use toCode() instead
    public static String getValueByDisplayName(String frequency) {
        return Arrays.stream(Frequency.values())
                .filter(lifeFrequency -> lifeFrequency.getDisplayName().equalsIgnoreCase(frequency))
                .findFirst().map(Frequency::getCode)
                .orElse("N/A");
    }
}

class FrequencyMappingException extends Exception {
    public FrequencyMappingException(String message) {
        super(message);
    }
}