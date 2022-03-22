package ru.javarush.khozhasaitov.cryptoanalyzer.commands;

import java.util.List;

public class Encoder extends Cryptoanalyzer{

    public Encoder() {
        super();
        workWithFile();
        endWork();
    }
    protected void endWork() {
        System.out.println("Файл успешно зашифрован.");

    }

        @Override
    protected void hello() {
        System.out.println("Вы выбрали процедуру шифрования.");
    }
    protected List<String> criptoanalyzer(List<String> stringsFile, char[] alphabet) {
        inputKey();
        return super.criptoanalyzer(stringsFile, alphabet);

    }

    @Override
    protected String switchChars(String str, char[] alphabet) {
        String result;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int num = 0;
            for (int j = 0; j < alphabet.length; j++) {
                if (chars[i] == alphabet[j]) {
                    num = j;
                    break;
                }
            }

            chars[i] = alphabet[(num + key) % alphabet.length];
        }

        result = String.valueOf(chars);
        return  result;

    }
}
