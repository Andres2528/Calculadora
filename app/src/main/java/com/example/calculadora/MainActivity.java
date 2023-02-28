package com.example.calculadora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView visor;
    double num1 = 0;
    double num2 = 0;
    double respuesta;
    String operacion;
    String estadoActual = "num1";
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button suma;
    Button resta;
    Button multiplica;
    Button dividir;
    Button igual;
    Button coma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visor = findViewById(R.id.visor);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn0 = findViewById(R.id.button0);
        suma = findViewById(R.id.buttonmas);
        resta = findViewById(R.id.buttonmenos);
        multiplica = findViewById(R.id.buttonpor);
        dividir = findViewById(R.id.buttondividir);
        igual = findViewById(R.id.buttonigual);
        coma = findViewById(R.id.buttoncoma);
    }

    public void igual(View view){
        switch (operacion){
            case "+":
                respuesta = suma(num1, num2);
                break;
            case "-":
                respuesta = resta(num1, num2);
                break;
            case "x":
                respuesta = multiplicacion(num1, num2);
                break;
            case "/":
                respuesta = divicion(num1, num2);
                break;
        }
        estadoActual = "num1";
        num1 = respuesta;
        num2 = 0;
        visor.setText(String.valueOf(respuesta));
    }
    public void colocarDecimal(View view){
        String datoPantalla = visor.getText().toString();

        Pattern patron = Pattern.compile("[0-9]+");
        Matcher matcher = patron.matcher(datoPantalla);

        if(matcher.matches()){
            if(estadoActual.equals("num1")){
                datoPantalla = datoPantalla + ".";
            } else if (estadoActual.equals("num2")) {
                datoPantalla = datoPantalla + ".";
            }
        }

        visor.setText(datoPantalla);
    }
    public void sumar(View view){
        operacion = suma.getText().toString();
        visualizar(operacion, 0);
    }
    public void restar(View view){
        operacion = resta.getText().toString();
        visualizar(operacion, 0);
    }
    public void multiplicar(View view){
        operacion = multiplica.getText().toString();
        visualizar(operacion, 0);
    }
    public void dividir(View view){
        operacion = dividir.getText().toString();
        visualizar(operacion, 0);
    }
    public void boton1(View view){
        visualizar(btn1.getText().toString(), 1);
    }
    public void boton2(View view){
        visualizar(btn2.getText().toString(), 1);
    }
    public void boton3(View view){
        visualizar(btn3.getText().toString(), 1);
    }
    public void boton4(View view){
        visualizar(btn4.getText().toString(), 1);
    }
    public void boton5(View view){
        visualizar(btn5.getText().toString(), 1);
    }
    public void boton6(View view){
        visualizar(btn6.getText().toString(), 1);
    }
    public void boton7(View view){
        visualizar(btn7.getText().toString(), 1);
    }
    public void boton8(View view){
        visualizar(btn8.getText().toString(), 1);
    }
    public void boton9(View view){
        visualizar(btn9.getText().toString(), 1);
    }
    public void boton0(View view){
        visualizar(btn0.getText().toString(), 1);
    }


    public void botonBorrarTodo(View view){
        num1 = 0;
        num2 = 0;
        estadoActual = "num1";
        visualizar("", 1);
    }

    public void borrarUltimaCifra (View view){
        String str = visor.getText().toString();
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
            visor.setText("");
        }
        else if(!str.isEmpty() && str.length() > 1){
            str = str.substring(0, str.length()-1);
            visor.setText(str);

            if(estadoActual.equals("num1")){
                num1 = Double.parseDouble(str);
            }
            else if (estadoActual.equals("num2")){
                num2 = Double.parseDouble(str);
            }
        }
        else if(str.length() == 1){
            visor.setText("");
        }
    }

    private void CambioEstadoActual(){
        estadoActual = "num2";
    }

    private double suma (double num1, double num2){
        //Log.d("Prueba", "ENTROOO suma");
        return num1 + num2;
    }

    private double resta (double num1, double num2){
        //Log.d("Prueba", "ENTROOO resta");
        return num1 - num2;
    }

    private double multiplicacion (double num1, double num2){
        //Log.d("Prueba", "ENTROOO mul");
        return num1 * num2;
    }

    private double divicion (double num1, double num2){
        //Log.d("Prueba", "ENTROOO divi");
        double respuesta = 0;

        if (num2!=0){
            respuesta = num1 / num2;
        }

        return respuesta;
    }

    private void visualizar (@NonNull String vi, int condicion){
        if(vi.equals("")){
            visor.setText("");
        }
        else if (condicion == 0){
            CambioEstadoActual();
            visor.setText(vi);
        }
        else {
            if(estadoActual.equals("num1")){
                if(num1 != 0){
                    String numero1 = visor.getText().toString();
                    String numeroConcat = numero1 + vi;
                    visor.setText(numeroConcat);
                    num1 = Double.parseDouble(numeroConcat);
                }
                else{
                    visor.setText(vi);
                    num1 = Double.parseDouble(vi);
                }

            }
            else if (estadoActual.equals("num2")) {
                if(num2 != 0){
                    String numero2 = visor.getText().toString();
                    String numeroConcat = numero2 + vi;
                    visor.setText(numeroConcat);
                    num2 = Double.parseDouble(numeroConcat);
                }
                else{
                    visor.setText(vi);
                    num2 = Double.parseDouble(vi);
                }
            }

        }
    }
}