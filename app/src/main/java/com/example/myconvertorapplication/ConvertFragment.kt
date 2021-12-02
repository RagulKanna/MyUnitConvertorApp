package com.example.myconvertorapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment


class ConvertFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_convert, container, false)

        val convertButton = view.findViewById<ImageButton>(R.id.convert_button)
        val resetButton = view.findViewById<ImageButton>(R.id.reset_button)
        val inputValue = view.findViewById<EditText>(R.id.inputValue)
        val outputValue = view.findViewById<TextView>(R.id.outputValue)
        val spinnerMain = view.findViewById<Spinner>(R.id.mainMetricSpinner)
        val spinnerInput = view.findViewById<Spinner>(R.id.inputMetricSpinner)
        val spinnerOutput = view.findViewById<Spinner>(R.id.outputMetricSpinner)

        val mainMetrics = ArrayList<String>()
        mainMetrics.add(MetricConstant.METRIC_LENGTH)
        mainMetrics.add(MetricConstant.METRIC_VOLUME)
        mainMetrics.add(MetricConstant.METRIC_TEMPERATURE)

        val lengthMetrics = ArrayList<String>()
        lengthMetrics.add(MetricConstant.METRIC_KILOMETER)
        lengthMetrics.add(MetricConstant.METRIC_METER)
        lengthMetrics.add(MetricConstant.METRIC_CENTIMETER)
        lengthMetrics.add(MetricConstant.METRIC_MILES)

        val volumeMetrics = ArrayList<String>()
        volumeMetrics.add(MetricConstant.METRIC_LITRE)
        volumeMetrics.add(MetricConstant.METRIC_MILLILITRE)
        volumeMetrics.add(MetricConstant.METRIC_GALLON)

        val temperatureMetrics = ArrayList<String>()
        temperatureMetrics.add(MetricConstant.METRIC_CELSIUS)
        temperatureMetrics.add(MetricConstant.METRIC_KELVIN)
        temperatureMetrics.add(MetricConstant.METRIC_FAHRENHEIT)


        var selectedMainMetrics = ""
        var selectedOutputMetrics = ""
        var selectedInputMetrics = ""

        val mainMetricAdapter: ArrayAdapter<String>? =
            activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_spinner_dropdown_item, mainMetrics) }
        spinnerMain.adapter = mainMetricAdapter

        val lengthMetricAdapter: ArrayAdapter<String>? =
            activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_spinner_dropdown_item, lengthMetrics) }


        val volumeMetricAdapter: ArrayAdapter<String>? =
            activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_spinner_dropdown_item, volumeMetrics) }


        val temperatureMetricAdapter: ArrayAdapter<String>? =
            activity?.let {
                ArrayAdapter<String>(
                    it,
                    android.R.layout.simple_spinner_dropdown_item,
                    temperatureMetrics
                )
            }

        fun assigningMetricsArray(array: ArrayList<String>) {
            spinnerInput.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        selectedInputMetrics = array[position]
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }
            spinnerOutput.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        selectedOutputMetrics = array[position]
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }
        }

        spinnerMain.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedMainMetrics = mainMetrics[position]
                when (selectedMainMetrics) {
                    MetricConstant.METRIC_LENGTH -> {
                        spinnerInput.adapter = lengthMetricAdapter
                        spinnerOutput.adapter = lengthMetricAdapter
                        assigningMetricsArray(lengthMetrics)
                    }
                    MetricConstant.METRIC_VOLUME -> {
                        spinnerInput.adapter = volumeMetricAdapter
                        spinnerOutput.adapter = volumeMetricAdapter
                        assigningMetricsArray(volumeMetrics)
                    }
                    MetricConstant.METRIC_TEMPERATURE -> {
                        spinnerInput.adapter = temperatureMetricAdapter
                        spinnerOutput.adapter = temperatureMetricAdapter
                        assigningMetricsArray(temperatureMetrics)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

        val function = Conversion()

        convertButton.setOnClickListener {
            val value = Integer.valueOf(inputValue.text.toString())

            when (selectedMainMetrics) {
                MetricConstant.METRIC_LENGTH -> {
                    val result = function.calculatingLengthMetrics(
                        selectedInputMetrics,
                        selectedOutputMetrics,
                        value.toDouble()
                    )
                    outputValue.text = result.toString()
                }
                MetricConstant.METRIC_VOLUME -> {
                    val result = function.calculatingVolumeMetrics(
                        selectedInputMetrics,
                        selectedOutputMetrics,
                        value.toDouble()
                    )
                    outputValue.text = result.toString()
                }
                MetricConstant.METRIC_TEMPERATURE -> {
                    val result = function.calculatingTemperatureMetrics(
                        selectedInputMetrics,
                        selectedOutputMetrics,
                        value.toDouble()
                    )
                    outputValue.text = result.toString()
                }
            }
        }

        resetButton.setOnClickListener {
            when (selectedMainMetrics) {
                MetricConstant.METRIC_LENGTH -> {
                    spinnerInput.setSelection(0)
                    spinnerOutput.setSelection(0)
                }
                MetricConstant.METRIC_VOLUME -> {
                    spinnerInput.setSelection(0)
                    spinnerOutput.setSelection(0)
                }
                MetricConstant.METRIC_TEMPERATURE -> {
                    spinnerInput.setSelection(0)
                    spinnerOutput.setSelection(0)
                }
            }
            inputValue.setText("")
            outputValue.text = ""
        }

        return view
    }
}