package ru.javarush.khozhasaitov.cryptoanalyzer.commands;

import ru.javarush.khozhasaitov.cryptoanalyzer.constants.Constants;
import ru.javarush.khozhasaitov.cryptoanalyzer.controllers.WorkWithFiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Cryptoanalyzer {
    protected int key;
    protected List<String> finaleListStr;

    public Cryptoanalyzer() {
        hello();
        WorkWithFiles workWithFiles = new WorkWithFiles();
        workWithFiles.readFile(workWithFiles.getSource());
        finaleListStr = criptoanalyzer(workWithFiles.getStringsFile(), Constants.getAlphabet());
        workWithFiles.setStringsResultFile(finaleListStr);
        workWithFiles.writeFile(finaleListStr);
        endWork();
    }

    protected void endWork() {
        try {
            Thread.sleep(2000);
            System.out.println("Все шифры переданы в Роскомнадзор.");
            Thread.sleep(2000);
            System.out.println( "За вами уже выехали.");
            Thread.sleep(2000);
            System.out.println("Беги глупец!!!");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Шутка)))");

    }

    protected List<String> criptoanalyzer(List<String> stringsFile, char[] alphabet) {

        String resultStr;
        List<String> resultList = new ArrayList<>();
        for (String s : stringsFile) {
            resultStr = switchChars(s, alphabet);
            resultList.add(resultStr);
        }
        return resultList;

    }

    protected void inputKey() {
        System.out.printf("Введите ключ шифрования (целое положительное число от 0 до %d): ", Constants.getAlphabet().length -1);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                key = scanner.nextInt();
                if (key > 0) {
                    break;
                } else {
                    System.out.println("Вы ввели отрицательное число. Попробуте снова");
                }
            } else {
                System.out.println("Вы ввели не целое число. Попробуйте снова.");
            }
        }
        scanner.close();
    }
    protected abstract String switchChars(String str, char[] alphabet);

    protected abstract void hello();
}

