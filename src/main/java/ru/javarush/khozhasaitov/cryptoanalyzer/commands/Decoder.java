package ru.javarush.khozhasaitov.cryptoanalyzer.commands;

import java.util.List;

public class Decoder extends Cryptoanalyzer{

    public Decoder() {
        super();
    }

    @Override
    protected String switchChars(String str, char[] alphabet) {
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
                if (num - key < 0) {
                    ch = alphabet[alphabet.length -(num - key) * -1 ];
                } else {
                    ch = alphabet[(num - key) % alphabet.length];
                }

            chars[i] = ch;
        }

        result = String.valueOf(chars);
        return  result;

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
        super.endWork();
    }
}
