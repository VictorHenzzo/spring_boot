package com.wykmmam.rest_spring_java.request.converters;

import com.wykmmam.rest_spring_java.exception.ResourceNotFoundException;

public class NumberConverter {
    static public Double convertToDouble(String number) throws
            ResourceNotFoundException {
        if (isNotNumeric(number)) {
            throw new ResourceNotFoundException(
                    "Please provide a numeric value!");
        }

        return Double.parseDouble(number);
    }

    static private boolean isNotNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            return true;
        }
        String number = strNumber.replace(",", ".");
        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
