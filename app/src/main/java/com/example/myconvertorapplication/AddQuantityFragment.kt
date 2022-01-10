package com.example.myconvertorapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class AddQuantityFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_add_quantity, container, false)

        val input1 = view.findViewById<EditText>(R.id.textInput1)
        val input2 = view.findViewById<EditText>(R.id.textInput2)
        val output = view.findViewById<TextView>(R.id.textOutput)
        val spinner1 = view.findViewById<Spinner>(R.id.spinnerInput1)
        val spinner2 = view.findViewById<Spinner>(R.id.spinnerInput2)
        val spinner3 = view.findViewById<Spinner>(R.id.spinnerInput3)
        val spinnerMain = view.findViewById<Spinner>(R.id.mainSpinner)
        val convert = view.findViewById<ImageButton>(R.id.convert_button)

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
        var selectedInput1 = ""
        var selectedInput2 = ""
        var selectedInput3 = ""

        val mainMetricAdapter: ArrayAdapter<String>? =
            activity?.let {
                ArrayAdapter<String>(
                    it,
                    android.R.layout.simple_spinner_dropdown_item,
                    mainMetrics
                )
            }
        spinnerMain.adapter = mainMetricAdapter

        val lengthMetricAdapter: ArrayAdapter<String>? =
            activity?.let {
                ArrayAdapter<String>(
                    it,
                    android.R.layout.simple_spinner_dropdown_item,
                    lengthMetrics
                )
            }

        val volumeMetricAdapter: ArrayAdapter<String>? =
            activity?.let {
                ArrayAdapter<String>(
                    it,
                    android.R.layout.simple_spinner_dropdown_item,
                    volumeMetrics
                )
            }

        val temperatureMetricAdapter: ArrayAdapter<String>? =
            activity?.let {
                ArrayAdapter<String>(
                    it,
                    android.R.layout.simple_spinner_dropdown_item,
                    temperatureMetrics
                )
            }

        fun assigningMetricsArray(array: ArrayList<String>) {
            spinner1.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        selectedInput1 = array[position]
                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }
            spinner2.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        selectedInput2 = array[position]
                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }
            spinner3.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        selectedInput3 = array[position]
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
                        spinner1.adapter = lengthMetricAdapter
                        spinner2.adapter = lengthMetricAdapter
                        spinner3.adapter = lengthMetricAdapter
                        assigningMetricsArray(lengthMetrics)
                    }
                    MetricConstant.METRIC_VOLUME -> {
                        spinner1.adapter = volumeMetricAdapter
                        spinner2.adapter = volumeMetricAdapter
                        spinner3.adapter = volumeMetricAdapter
                        assigningMetricsArray(volumeMetrics)
                    }
                    MetricConstant.METRIC_TEMPERATURE -> {
                        spinner1.adapter = temperatureMetricAdapter
                        spinner2.adapter = temperatureMetricAdapter
                        spinner3.adapter = temperatureMetricAdapter
                        assigningMetricsArray(temperatureMetrics)
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        val convertFunction = Conversion()

        convert.setOnClickListener {

            when (selectedMainMetrics) {
                MetricConstant.METRIC_LENGTH -> {
                    val value1 = input1.text.toString().toDouble()
                    val value2 = input2.text.toString().toDouble()
                    val partialResult =
                        convertFunction.calculatingLengthMetrics(selectedInput1, selectedInput2, value1)
                    val value3 = value2 + partialResult
                    val result =
                        convertFunction.calculatingLengthMetrics(selectedInput2, selectedInput3, value3)
                    output.text = result.toString()
                }
                MetricConstant.METRIC_VOLUME -> {
                    val value1 = input1.text.toString().toDouble()
                    val value2 = input2.text.toString().toDouble()
                    val partialResult =
                        convertFunction.calculatingVolumeMetrics(selectedInput1, selectedInput2, value1)
                    val value3 = value2 + partialResult
                    val result =
                        convertFunction.calculatingVolumeMetrics(selectedInput2, selectedInput3, value3)
                    output.text = result.toString()
                }
                MetricConstant.METRIC_TEMPERATURE -> {
                    val value1 = input1.text.toString().toDouble()
                    val value2 = input2.text.toString().toDouble()
                    val partialResult = convertFunction.calculatingTemperatureMetrics(
                        selectedInput1,
                        selectedInput2,
                        value1
                    )
                    val value3 = value2 + partialResult
                    val result =
                        convertFunction.calculatingTemperatureMetrics(selectedInput2, selectedInput3, value3)
                    output.text = result.toString()
                }
            }
        }
        return view
    }
}