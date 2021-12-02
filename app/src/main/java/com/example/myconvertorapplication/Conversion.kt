package com.example.myconvertorapplication

class Conversion {

    fun calculatingLengthMetrics(
        selectedInputMetrics: String,
        selectedOutputMetrics: String,
        value: Double
    ): Double {

        if (selectedInputMetrics == MetricConstant.METRIC_KILOMETER && selectedOutputMetrics == MetricConstant.METRIC_METER)
            return value * 1000.0
        else if (selectedInputMetrics == MetricConstant.METRIC_KILOMETER && selectedOutputMetrics == MetricConstant.METRIC_CENTIMETER)
            return value * 100000.0
        else if (selectedInputMetrics == MetricConstant.METRIC_KILOMETER && selectedOutputMetrics == MetricConstant.METRIC_MILES)
            return value / 1.609
        else if (selectedInputMetrics == MetricConstant.METRIC_METER && selectedOutputMetrics == MetricConstant.METRIC_KILOMETER)
            return value / 1000.0
        else if (selectedInputMetrics == MetricConstant.METRIC_METER && selectedOutputMetrics == MetricConstant.METRIC_CENTIMETER)
            return value * 100.0
        else if (selectedInputMetrics == MetricConstant.METRIC_METER && selectedOutputMetrics == MetricConstant.METRIC_MILES)
            return value * 0.0006213712
        else if (selectedInputMetrics == MetricConstant.METRIC_CENTIMETER && selectedOutputMetrics == MetricConstant.METRIC_KILOMETER)
            return value / 100000.0
        else if (selectedInputMetrics == MetricConstant.METRIC_CENTIMETER && selectedOutputMetrics == MetricConstant.METRIC_MILES)
            return value / 160934.0
        else if (selectedInputMetrics == MetricConstant.METRIC_CENTIMETER && selectedOutputMetrics == MetricConstant.METRIC_METER)
            return value / 100.0
        else if (selectedInputMetrics == MetricConstant.METRIC_MILES && selectedOutputMetrics == MetricConstant.METRIC_METER)
            return value * 1609.0
        else if (selectedInputMetrics == MetricConstant.METRIC_MILES && selectedOutputMetrics == MetricConstant.METRIC_CENTIMETER)
            return value * 160934.0
        else if (selectedInputMetrics == MetricConstant.METRIC_MILES && selectedOutputMetrics == MetricConstant.METRIC_KILOMETER)
            return value * 1.609
        else
            return value
    }

    fun calculatingVolumeMetrics(
        selectedInputMetrics: String,
        selectedOutputMetrics: String,
        value: Double
    ): Double {
        return if (selectedInputMetrics == MetricConstant.METRIC_LITRE && selectedOutputMetrics == MetricConstant.METRIC_MILLILITRE)
            value * 1000.0
        else if (selectedInputMetrics == MetricConstant.METRIC_LITRE && selectedOutputMetrics == MetricConstant.METRIC_GALLON)
            value / 3.785
        else if (selectedInputMetrics == MetricConstant.METRIC_MILLILITRE && selectedOutputMetrics == MetricConstant.METRIC_GALLON)
            value / 3785.0
        else if (selectedInputMetrics == MetricConstant.METRIC_MILLILITRE && selectedOutputMetrics == MetricConstant.METRIC_LITRE)
            value / 1000.0
        else if (selectedInputMetrics == MetricConstant.METRIC_GALLON && selectedOutputMetrics == MetricConstant.METRIC_MILLILITRE)
            value * 3785.0
        else if (selectedInputMetrics == MetricConstant.METRIC_GALLON && selectedOutputMetrics == MetricConstant.METRIC_LITRE)
            value * 3.785
        else
           return value
    }

    fun calculatingTemperatureMetrics(
        selectedInputMetrics: String,
        selectedOutputMetrics: String,
        value: Double
    ): Double {
        return if (selectedInputMetrics == MetricConstant.METRIC_CELSIUS && selectedOutputMetrics == MetricConstant.METRIC_KELVIN)
            value + 273.15
        else if (selectedInputMetrics == MetricConstant.METRIC_CELSIUS && selectedOutputMetrics == MetricConstant.METRIC_FAHRENHEIT)
            (((value * 9.0) / 5.0) + 32.0)
        else if (selectedInputMetrics == MetricConstant.METRIC_KELVIN && selectedOutputMetrics == MetricConstant.METRIC_FAHRENHEIT)
            ((((value - 273.15) * 9.0) / 5.0) + 32.0)
        else if (selectedInputMetrics == MetricConstant.METRIC_KELVIN && selectedOutputMetrics == MetricConstant.METRIC_CELSIUS)
            value - 273.15
        else if (selectedInputMetrics == MetricConstant.METRIC_FAHRENHEIT && selectedOutputMetrics == MetricConstant.METRIC_KELVIN)
            (((value - 32.0) * 5.0) / 9.0) + 273.15
        else if (selectedInputMetrics == MetricConstant.METRIC_FAHRENHEIT && selectedOutputMetrics == MetricConstant.METRIC_CELSIUS)
            (((value - 32.0) * 5.0) / 9.0)
        else
           return value
    }
}