package com.example.contador

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contador.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var panel: String = "0"
    private var n1: Double = 0.0
    private var operador: String = ""
    private var panelClean: Boolean = false
    private var modoCientifica: Boolean = false
    private var resultado: Double = 0.0
    private var controlCalculoPotenciaComplejo: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inicializa el binding para que se enlace la vista con la lógica
        //se utiliza para poder acceder a todos los elementos de los layouts
        // a través de la variable Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        //como definimos panel como Int, pero permitimos que savedInstanceState sea nulo,
        //Tenemos que darle un valor por defecto.
        panel = savedInstanceState?.getString("panel") ?: "0"
        binding.btn0.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)
        binding.GridBotonera.setOnClickListener(this)
        binding.btnComa.setOnClickListener(this)
        binding.btnAc.setOnClickListener(this)
        binding.btnConvertidorPToN.setOnClickListener(this)
        binding.btnDividir.setOnClickListener(this)
        binding.btnIgual.setOnClickListener(this)
        binding.btnMultiplicar.setOnClickListener(this)
        binding.btnResta.setOnClickListener(this)
        binding.btnPorcentaje.setOnClickListener(this)
        binding.btnSuma.setOnClickListener(this)
        binding.btnRotacion.setOnClickListener(this)
        binding.btnParentesisA?.setOnClickListener(this)
        binding.btnParentesisC?.setOnClickListener(this)
        binding.btnMplus?.setOnClickListener(this)
        binding.btnMminus?.setOnClickListener(this)
        binding.btnX2?.setOnClickListener(this)
        binding.btnX3?.setOnClickListener(this)
        binding.btnXy?.setOnClickListener(this)
        binding.btnEx?.setOnClickListener(this)
        binding.btnLogaritmoNatural?.setOnClickListener(this)
        binding.btnLike?.setOnClickListener(){Snackbar.make(it,"Gracias por darle a Like, aunque sea un botón innecesario!", Snackbar.LENGTH_LONG).show()}
        binding.btnFactorial?.setOnClickListener(this)
        binding.btnPi?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.btn0.id->{addNumbers("0")}
            binding.btn1.id->{addNumbers("1")}
            binding.btn2.id->{addNumbers("2")}
            binding.btn3.id->{addNumbers("3")}
            binding.btn4.id->{addNumbers("4")}
            binding.btn5.id->{addNumbers("5")}
            binding.btn6.id->{addNumbers("6")}
            binding.btn7.id->{addNumbers("7")}
            binding.btn8.id->{addNumbers("8")}
            binding.btn9.id->{addNumbers("9")}
            binding.btnRotacion.id->{cambioOrientacion()}
            binding.btnComa.id->{addNumbers(".")}
            binding.btnAc.id->{limpiarPanel()}
            binding.btnConvertidorPToN.id->{conversorPN(panel)}
            binding.btnDividir.id->{seleccionarOperador("/")}
            binding.btnIgual.id->{
                if (controlCalculoPotenciaComplejo){
                    calculoPotenciasComplejas()
                }else{
                    calcularResultado(n1,panel,operador)
                }
            }
            binding.btnMultiplicar.id->{seleccionarOperador("*")}
            binding.btnResta.id->{seleccionarOperador("-")}
            binding.btnPorcentaje.id->{calcularPorcentaje(panel)}
            binding.btnSuma.id->{seleccionarOperador("+")}
            binding.btnParentesisA?.id->{}
            binding.btnParentesisC?.id->{}
            binding.btnMplus?.id->{}
            binding.btnMminus?.id->{}
            binding.btnX2?.id->{calculoPotenciasSimples(panel,"2")}
            binding.btnX3?.id->{calculoPotenciasSimples(panel,"3")}
            binding.btnXy?.id->{calculoPotenciasComplejas()}
            binding.btnEx?.id->{calculoEuler(panel)}
            binding.btnLogaritmoNatural?.id->{calculoLogaritmoNatural(panel)}
            binding.btnFactorial?.id->{}
            binding.btnPi?.id->{}

        }
    }

    private fun addNumbers(numero: String){
       if (panel == "0" && numero != "."){
           panel = numero
       }else if(numero == "." && panel.contains(".")) {
           println("Estás intentando poner 2 puntos es una cifra.")
           return
       }else {
            panel += numero
       }
        actualizarPanel(panel)
    }
    private fun actualizarPanel(numeroActual: String){
        binding.panelNumerico.setText(numeroActual)
    }
    private fun limpiarPanel(){
        panel = "0"
        binding.panelNumerico.setText("0")
    }
    private fun cambioOrientacion(){
        if (modoCientifica){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }else {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        modoCientifica = !modoCientifica
    }
    private fun seleccionarOperador(operador :String){
        guardarPrimerNumero()
        limpiarPanel()
        this.operador = operador
    }
    private fun guardarPrimerNumero(){
        n1 = panel.toDoubleOrNull()?: 0.0
        if (n1 == 0.0){
            println("Ojo, ¿no se ha registrado bien el double? $n1 ")
        }
    }
    private fun calcularPorcentaje(valor: String){
        var porcentaje:Double  = valor.toDoubleOrNull()?: 0.0
        porcentaje = porcentaje/100
        actualizarPanel(porcentaje.toString())
    }
    private fun calcularResultado(valor1: Double,valor2: String,operador: String){
        val n2 = valor2.toDoubleOrNull()?: 0.0
        when(operador) {
            "+" -> resultado = valor1 + n2
            "-" -> resultado = valor1 - n2
            "*" -> resultado = valor1 * n2
            "/" -> {
                if (n2 == 0.0) {
                     // Manejar la división por cero
                    throw ArithmeticException("No se puede dividir por cero")
                } else {
                        resultado = valor1 / n2
                }
            }
            else -> {
                // Manejar operadores no válidos
                throw IllegalArgumentException("Operador no válido: $operador")
            }
        }
        actualizarPanel(resultado.toString())
    }
    private fun conversorPN(valor: String){
        var valorN = valor.toDoubleOrNull()?: 0.0
        valorN *= -1
        actualizarPanel(valorN.toString())
    }
    private fun calculoPotenciasSimples(valor: String, disparador: String){
        var resultado = Math.pow((valor.toDoubleOrNull()?: 0.0),(disparador.toDoubleOrNull()?: 0.0))
        actualizarPanel(resultado.toString())
    }
    private fun calculoPotenciasComplejas(){
        if(controlCalculoPotenciaComplejo){
            var num2 = panel.toDoubleOrNull()?: 0.0
            actualizarPanel(Math.pow(n1,num2).toString())
            controlCalculoPotenciaComplejo = !controlCalculoPotenciaComplejo
        }else{
            guardarPrimerNumero()
            limpiarPanel()
            controlCalculoPotenciaComplejo = !controlCalculoPotenciaComplejo
        }
    }
    private fun calculoEuler(valor: String){
        var n1 = valor.toDoubleOrNull()?: 0.0
        actualizarPanel(Math.exp(n1).toString())
    }
    private fun calculoLogaritmoNatural(valor: String){
        var n1 = valor.toDoubleOrNull()?: 0.0
        actualizarPanel(Math.log(n1).toString())
    }

    /* por implementar
    private fun normalizacionDatos(Value: String){
        return (value.toDoubleOrNull:? 0.0)
    }
     */


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("panel", panel)
    }

}