package ru.javarush.khozhasaitov.cryptoanalyzer.commands;

import java.util.List;

public class Decoder extends Cryptoanalyzer {

    public Decoder() {
        super();
        workWithFile();
        endWork();
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
            if (num - key < 0) {
                chars[i] = alphabet[alphabet.length - (num - key) * -1];
            } else {
                chars[i] = alphabet[(num - key) % alphabet.length];
            }


        }

        result = String.valueOf(chars);
        return result;

    }

    protected List<String> criptoanalyzer(List<String> stringsFile, char[] alphabet) {
        inputKey();
        return super.criptoanalyzer(stringsFile, alphabet);

    }

    @Override
    protected void hello() {
        System.out.println("Файл успешно дешифрован.");
    }

    protected void endWork() {
        System.out.println("Файл успешно расшифрован.");

    }
}
