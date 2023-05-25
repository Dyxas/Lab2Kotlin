package com.example.lab2

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showMessage(mes: String)
    {
        val toast = Toast.makeText(this@MainActivity, mes, Toast.LENGTH_LONG)
        toast.show();
    }

    fun onCalculate(view: View)
    {
        val oTextA : Double? = (findViewById(R.id.editTextNumber2) as EditText).text.toString().toDoubleOrNull()
        val oTextB : Double? = (findViewById(R.id.editTextNumber3) as EditText).text.toString().toDoubleOrNull()
        val oTextC : Double? = (findViewById(R.id.editTextNumber4) as EditText).text.toString().toDoubleOrNull()

        if (oTextA == null || oTextB == null || oTextC == null) {
            showMessage("Заполните все поля");
            return;
        }

        val sum = abs(oTextA) + abs(oTextB) + abs(oTextC)
        if (sum == 0.0) {
            showMessage("Бесконечное множество корней");
            return;
        }
        val x1: Double;
        val x2: Double;

        if (oTextA == 0.0 && oTextB != 0.0) {
            val x: Double = (-1 * oTextC) / oTextB
            showMessage("A == 0. Линейное уравнение: $x")
            return
        } else if (oTextA == 0.0 && oTextB == 0.0 && oTextC != 0.0)
        {
            showMessage("Корней нет");
            return
        }

        val discriminant: Double = Math.pow(oTextB, 2.0) - 4 * oTextA * oTextC;


        if (discriminant < 0)
        {
            showMessage("D < 0. Корней нет");
        }
        else
        {
            if (discriminant == 0.0)
            {
                x1 = -oTextB / (2 * oTextA);
                showMessage("D = 0. Уравнение имеет один корень: x1 = $x1");
                return;
            }
            else
            {
                x1 = (-oTextB + Math.sqrt(discriminant)) / (2 * oTextA);
                x2 = (-oTextB - Math.sqrt(discriminant)) / (2 * oTextA);
            }

            showMessage("D > 0. Корни уравнения: x1 = $x1 .\n x2 = $x2");
        }
    }
}