package com.wykmmam.rest_spring_java.math;

import com.wykmmam.rest_spring_java.exception.UnsupportedMathOperationException;

import java.util.List;

import static java.lang.Math.sqrt;

public class SimpleMath {
    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double multiply(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double divide(Double numerator, Double denominator) throws
            UnsupportedMathOperationException {
        if (denominator == 0) {
            throw new UnsupportedMathOperationException("Can't divide by " +
                    "zero!");
        }

        return numerator / denominator;
    }


    public Double average(
            List<Double> numbers
    ) {
        if (numbers.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (Double current : numbers) {
            sum += current;
        }

        return sum / numbers.size();
    }


    public Double squareRoot(
            Double radicand
    ) {
        return sqrt(radicand);
    }
}
