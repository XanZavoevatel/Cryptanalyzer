package ru.javarush.khozhasaitov.cryptoanalyzer.commands;

import ru.javarush.khozhasaitov.cryptoanalyzer.constants.Constants;
import ru.javarush.khozhasaitov.cryptoanalyzer.controllers.WorkWithFiles;

import java.util.*;

public class DecoderBrutalForce extends Cryptoanalyzer {
    private boolean isNotComplete;
    protected int key = 0;

    public DecoderBrutalForce(boolean isNotComplete) {
        this.isNotComplete = isNotComplete;

        WorkWithFiles workWithFiles = new WorkWithFiles();
        workWithFiles.readFile(workWithFiles.getSource());
        do {
            finaleListStr = criptoanalyzer(workWithFiles.getStringsFile(), Constants.getAlphabet());
            isNotComplete = checkedComplete(Constants.getAlphabet());
            key++;

        } while (isNotComplete);
        workWithFiles.setStringsResultFile(finaleListStr);
        workWithFiles.writeFile();
        endWork();
    }

    private boolean checkedComplete(char[] alphabet) {
        int[] frequencies = new int[alphabet.length];
        char[] chars = finaleListStr.toString().toCharArray();
        for (char aChar : chars) {
            for (int j = 0; j < alphabet.length; j++) {
                if (aChar == alphabet[j]) {
                    frequencies[j]++;
                }
            }
        }

        int shiftInAlpf = 0;
        int intShiftInText = 0;
        int maxValue = 0;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > maxValue) {
                intShiftInText = i;
                maxValue = frequencies[i];
            }
        }

        return alphabet[intShiftInText] != alphabet[shiftInAlpf];
    }

    @Override
    protected List<String> criptoanalyzer(List<String> stringsFile, char[] alphabet) {
        String resultStr;
        List<String> resultList = new ArrayList<>();
        for (String s : stringsFile) {
           resultStr = switchChars(s, alphabet);
           resultList.add(resultStr);
        }
        return resultList;
    }

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
            ch = alphabet[(num + key) % alphabet.length];

            chars[i] = ch;
        }
        result = String.valueOf(chars);
        return result;
    }

    @Override
    protected void hello() {
        String MESSAGE = "Вы выбрали процедуру дешифровки методом перебора.";
        System.out.println(MESSAGE);
    }
}
