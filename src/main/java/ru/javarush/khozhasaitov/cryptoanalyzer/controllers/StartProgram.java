package ru.javarush.khozhasaitov.cryptoanalyzer.controllers;

import ru.javarush.khozhasaitov.cryptoanalyzer.commands.Decoder;
import ru.javarush.khozhasaitov.cryptoanalyzer.commands.DecoderBrutalForce;
import ru.javarush.khozhasaitov.cryptoanalyzer.commands.Encoder;

import java.util.Scanner;

public class StartProgram {
    private static final String HELLO = "Приветствую в программе криптоанализа текстовых файлов!";
    private static final String CHOICE = "Выберите процедуру: ";
    private static final String BAD_CHOICE = "Вы ввели неправильное число (от 1 до 4). Попробуйте снова.";



    public  static void start() {
        System.out.println(HELLO);
        int choise;
        System.out.println(CHOICE + "\n1. Зашифровать файл ключом" + "\n2. Расшифровать файл ключом" +
                "\n3. Расшифровать файл методом Brutal Forse" + "\n4. Выход");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
            choise=scanner.nextInt();
            break;
            } else {
                System.out.println(BAD_CHOICE);
            }
        }
        switch (choise) {
            case 1 -> new Encoder();
            case 2 -> new Decoder();
            case 3 -> new DecoderBrutalForce(true);
            case 4 -> System.exit(0);
        }


    }
}
