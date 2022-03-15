package ru.javarush.khozhasaitov.cryptoanalyzer.commands;


import ru.javarush.khozhasaitov.cryptoanalyzer.constants.Constants;
import ru.javarush.khozhasaitov.cryptoanalyzer.controllers.WorkWithFiles;


import java.util.*;

public class EncoderDecoder implements DoIter{
    private boolean encoder = false;
    private int key;
    private  List<String> finaleListStr;

//    public List<String> getFinaleListStr() {
//        return finaleListStr;
//    }

    public EncoderDecoder(boolean encoder) {
        this.encoder = encoder;
        if (encoder) {
            System.out.println("Вы выбрали процедуру шифрования.");
        } else {
            System.out.println("Вы выбрали процедуру дешифровки.");
        }
        WorkWithFiles workWithFiles = new WorkWithFiles();
        workWithFiles.readFile(workWithFiles.getSource());
        finaleListStr = doIter(workWithFiles.getStringsFile(), Constants.getAlphabet(), encoder);
        workWithFiles.setStringsResultFile(finaleListStr);
        workWithFiles.writeFile(finaleListStr);
        endWork(encoder);

    }

    @Override
    public void endWork(boolean encoder) {
        if (encoder) {
            System.out.println("Файл успешно зашифрован.");
        } else {
            System.out.println("Файл успешно дешифрован.");

        }
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

    @Override
    public List<String> doIter(List<String> stringsFile, char[] alphabet, boolean encoder) {
        System.out.printf("Введите ключ шифрования (целое положительное число от 0 до %d): ", alphabet.length-1);
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
        String resultStr;
        List<String> resultList = new ArrayList<>();
        for (String s : stringsFile) {
            resultStr = switchChars(s, alphabet, encoder);
            resultList.add(resultStr);
        }
        return resultList;
    }

    private String switchChars(String str, char[] alphabet, boolean encoder) {
        String result;
        char[] chars = str.toCharArray();
        char ch;
        for (int i = 0; i < chars.length; i++) {
            int num = 0;
            for (int j = 0; j < alphabet.length; j++) {
                if (chars[i] == alphabet[j]) {
                    num = j;
                    break;
                }
            }
            if (encoder) {
                ch = alphabet[(num + key) % alphabet.length];
            } else {
                if (num - key < 0) {
                    ch = alphabet[alphabet.length -(num - key) * -1 ];
                } else {
                    ch = alphabet[(num - key) % alphabet.length];
                }
            }
            chars[i] = ch;
        }

        result = String.valueOf(chars);
        return  result;
    }
}
