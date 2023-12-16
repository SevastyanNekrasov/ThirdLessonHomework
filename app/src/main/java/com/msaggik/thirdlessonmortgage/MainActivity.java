package com.msaggik.thirdlessonmortgage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // задание полей
    float robotCost = 35_000; // стоимость робота
    float amount = 1_700; // стипендия
    float account = 700; // счёт пользователя
    float percentBank = 9; // годовая процентная ставка

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView countOut; // поле вывода количества месяцев на получение робота

    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов activity_main
        countOut = findViewById(R.id.countOut); // вывод информации количества месяцев выплаты ипотеки

        // запонение экрана
        // 1) вывод количества месяцев накопления
        countOut.setText(countMonth(percentBank, amount, robotCost, account) + " месяцев");
    }

    // метод подсчёта времени накопления (годовой процент, стипендия, стоимость робота, накопления)
    public int countMonth(float percentBankYear, float amount, float robotCost, float account) {

        float percentBankMonth = percentBankYear / 12; // подсчёт ежемесячного процента банка
        float mortgageCosts = amount + ((account + amount) * (percentBankMonth/100)); // подсчёт ежемесячных поступлений на счет = платеж + процент на остаток
        int count = 0; // счётчик месяцев накопления

        // алгоритм расчёта времени покупки
        while (account <= robotCost) {
            count++; // добавление нового месяца платежа
            account = account + mortgageCosts; // состояния счета с учетом поступлений
        }

        return count;
    }
}