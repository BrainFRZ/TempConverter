package tempconverter;

/**
 *
 * @author Terry Weiss
 */
public class TempConverter {
    public static enum Temp_Type {
        CELSIUS {
            @Override
            public double convert(double fromTemp) {
                return (fromTemp * 1.8 + 32);
            }

            @Override
            public String toString() {
                return "Convert Celsius to Fahrenheit";
            }
        },
        FAHRENHEIT {
            @Override
            public double convert(double fromTemp) {
                return ((fromTemp - 32) * (5.0 / 9.0));
            }

            @Override
            public String toString() {
                return "Convert Fahrenheit to Celsius";
            }
        };

        abstract double convert(double fromTemp);

        public String getLabel() {
            String str = this.name();

            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }
    }




    private final Temp_Type convertingFrom;
    private final Temp_Type convertingTo;


    public TempConverter(Temp_Type convertFrom) {
        convertingFrom = convertFrom;

        if (convertFrom == Temp_Type.CELSIUS) {
            convertingTo = Temp_Type.FAHRENHEIT;
        }
        else if (convertFrom == Temp_Type.FAHRENHEIT) {
            convertingTo = Temp_Type.CELSIUS;
        }
        else {
            throw new TempTypeDoesntExistException("That temperature type isn't supported.");
        }
    }



    public double convertTemp(double fromTemp) {
        return convertingFrom.convert(fromTemp);
    }



    public Temp_Type fromTempType() {
        return convertingFrom;
    }

    public Temp_Type toTempType() {
        return convertingTo;
    }

    public String fromTempTypeStr() {
        return convertingFrom.getLabel();
    }

    public String toTempTypeStr() {
        return convertingTo.getLabel();
    }



    @Override
    public String toString() {
        return convertingFrom.getLabel() + " to " + convertingTo.getLabel() + " Converter";
    }




    /**
     * This Exception class is to be thrown in a menu when faulty input gets
     * through a prompt.
     */
    public static class TempTypeDoesntExistException extends IndexOutOfBoundsException {
        /**
         * Constructs a new OptionOutOfBounds exception using {@code null} as
         * its detail message.
         */
        public TempTypeDoesntExistException() { }

        /**
         * Constructs a new OptionOutOfBounds exception with the specified
         * detail message. The detail message is saved for later retrieval by
         * the {@link #getMessage()} method.
         *
         * @param message The message to be output before the stack trace.
         */
        public TempTypeDoesntExistException(String message) {
            super(message);
        }
    }
}
