package com.wykmmam.rest_spring_java.controllers;

import com.wykmmam.rest_spring_java.exception.UnsupportedMathOperationException;
import com.wykmmam.rest_spring_java.math.SimpleMath;
import com.wykmmam.rest_spring_java.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/math")
public class MathController {
    private final SimpleMath math = new SimpleMath();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) throws UnsupportedMathOperationException {
        return math.sum(
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/multiply/{numberOne}/{numberTwo}")
    public Double multiply(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) throws UnsupportedMathOperationException {
        return math.multiply(
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/divide/{numerator}/{denominator}")
    public Double divide(
            @PathVariable String numerator,
            @PathVariable String denominator
    ) throws UnsupportedMathOperationException {
        Double formattedDenominator =
                NumberConverter.convertToDouble(denominator);

        if (formattedDenominator == 0) {
            throw new UnsupportedMathOperationException("Can't divide by " +
                    "zero!");
        }

        return math.divide(
                NumberConverter.convertToDouble(numerator),
                formattedDenominator
        );
    }

    @RequestMapping("/average/{numbers}")
    public Double average(
            @PathVariable String[] numbers
    ) throws UnsupportedMathOperationException {
        List<Double> formattedNumbers = new ArrayList<>();


        for (String current : numbers) {
            formattedNumbers.add(NumberConverter.convertToDouble(current));
        }

        return math.average(formattedNumbers);
    }

    @RequestMapping("/squareRoot/{radicand}")
    public Double squareRoot(
            @PathVariable String radicand
    ) throws UnsupportedMathOperationException {
        return math.squareRoot(NumberConverter.convertToDouble(radicand));
    }

}
