package ru.javarush.khozhasaitov.cryptoanalyzer.controllers;

import ru.javarush.khozhasaitov.cryptoanalyzer.commands.Decoder;
import ru.javarush.khozhasaitov.cryptoanalyzer.commands.Encoder;

import java.util.Scanner;

public class StartProgram {
    private static final String HELLO = "Приветствую в программе криптоанализа текстовых файлов!";
    private static final String CHOICE = "Выберите процедуру: ";


    public  static void start() {
        System.out.println(HELLO);
        System.out.println(CHOICE + "\n1. Зашифровать файл ключом" + "\n2. Расшифровать файл ключом" +
                "\n3. Расшифровать файл методом Brutal Forse" + "\n4. Расшифровать файл с методом статистического анализа" +
                "\n5. Выход");
        Scanner scanner = new Scanner(System.in);
        int choise;
        while (true) {
            if (scanner.hasNextInt()) {
            choise=scanner.nextInt();
            break;
            } else {
                System.out.println("Вы ввели неправильное число (от 1 до 5). Попробуйте снова.");
            }
        }
        switch (choise) {
            case 1 -> new Encoder();
            case 2 -> new Decoder();
            case 5 -> System.exit(0);
        }


    }
}
