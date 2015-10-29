/**************************************************************************************************
 *  Program Name:     Temperature Converter
 *  Class Name:       tempconverter.TempConverter
 *  Author:           Terry Weiss
 *  Date Written:     October 24, 2015
 *  Program Description:
 *     This contains the backend logic of the temperature converter. The user is able to convert
 *  temperatures between Celsius and Fahrenheit. The user can switch between Celsius to
 *  Fahrenheit and Fahrenheit to Celsius by using a drop-down box, and then types the temperature
 *  they want to convert into a text field.
 **************************************************************************************************/
package tempconverter;

/**
 *
 * @author Terry Weiss
 */
public class TempConverter {
    /**
     * This contains the available temperature conversion types for the calculator. Currently
     * <tt>Celsius</tt> and <tt>Fahrenheit</tt> are supported. All conversion types have an
     * "output-friendly" label, a conversion formula and a String representation.
     */
    public static enum Temp_Type {
        CELSIUS {
            /**
             * Converts degrees Celsius to Fahrenheit.
             *
             * @param fromTemp Temperature to be converted from Celsius
             * @return Converted temperature in degrees Fahrenheit
             */
            @Override
            public double convert(double fromTemp) {
                return (fromTemp * 1.8 + 32);
            }

            /**
             * Represents the conversion type as a String description.
             *
             * @return String description
             */
            @Override
            public String toString() {
                return "Convert Celsius to Fahrenheit";
            }
        },
        FAHRENHEIT {
            /**
             * Converts degrees Fahrenheit to Celsius.
             *
             * @param fromTemp Temperature to be converted from Fahrenheit
             * @return Converted temperature in degrees Celsius
             */
            @Override
            public double convert(double fromTemp) {
                return ((fromTemp - 32) * (5.0 / 9.0));
            }

            /**
             * Represents the conversion type as a String description.
             *
             * @return String description
             */
            @Override
            public String toString() {
                return "Convert Fahrenheit to Celsius";
            }
        };

        /**
         * Converts degrees from the given degree to the converted degree. Each conversion type must
         * have its own formula.
         *
         * @param fromTemp Temperature to be converted
         * @return Converted temperature
         */
        abstract double convert(double fromTemp);

        /**
         * Provides an "output-friendly" label using the conversion type's name.
         *
         * @return "Output-friendly" label
         */
        public String getLabel() {
            String str = this.name();

            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }
    }




    private final Temp_Type convertingFrom;
    private final Temp_Type convertingTo;


    /**
     * Initializes a new TempConverter calculator using the specified conversion type.
     *
     * @param convertFrom Temperature type that the calculator will convert from
     * @see Temp_Type
     * @throws TempTypeDoesntExistException If an unsupported temperature type is used
     */
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



    /**
     * Calculates the converted temperature, using the current calculator's conversion type.
     *
     * @param fromTemp Degrees to be converted
     * @return Converted degrees
     * @see Temp_Type#convert(double)
     */
    public double convertTemp(double fromTemp) {
        return convertingFrom.convert(fromTemp);
    }



    /**
     * Provides the current {@link Temp_Type} the TempConverter calculator is converting from.
     *
     * @return Current Temp_Type being converted
     */
    public Temp_Type fromTempType() {
        return convertingFrom;
    }

    /**
     * Provides the current {@link Temp_Type} the TempConverter calculator is converting to.
     *
     * @return Current Temp_Type being converted to
     */
    public Temp_Type toTempType() {
        return convertingTo;
    }

    /**
     * Provides the label of the current {@link Temp_Type} the TempConverter calculator is
     * converting from.
     *
     * @return Current Temp_Type being converted
     * @see Temp_Type#getLabel()
     */
    public String fromTempTypeStr() {
        return convertingFrom.getLabel();
    }

    /**
     * Provides the label of the current {@link Temp_Type} the TempConverter calculator is
     * converting to.
     *
     * @return Current Temp_Type being converted to
     * @see Temp_Type#getLabel()
     */
    public String toTempTypeStr() {
        return convertingTo.getLabel();
    }



    /**
     * Provides the name of the converter, describing what {@link Temp_Type} the calculator is
     * converting from and to.
     *
     * @return Name of the TempConverter
     */
    @Override
    public String toString() {
        return convertingFrom.getLabel() + " to " + convertingTo.getLabel() + " Converter";
    }




    /**
     * This Exception class is to be thrown when an unsupported {@link Temp_Type} is used.
     */
    public static class TempTypeDoesntExistException extends IndexOutOfBoundsException {
        /**
         * Constructs a new TempTypeDoesntExistException exception using {@code null} as
         * its detail message.
         */
        public TempTypeDoesntExistException() { }

        /**
         * Constructs a new TempTypeDoesntExistException exception with the specified
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
