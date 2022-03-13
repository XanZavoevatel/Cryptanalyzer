package commands;


import constants.Constants;

import java.util.*;

public class Encoder implements DoIter{

    private int key;
    private  List<String> finaleListStr;

    public List<String> getFinaleListStr() {
        return finaleListStr;
    }

    public Encoder() {
        System.out.println("Вы выбрали процедуру шифрования.");
        WorkWithFiles workWithFiles = new WorkWithFiles();
        workWithFiles.readFile(workWithFiles.getSource());
        finaleListStr = doIter(workWithFiles.getStringsFile(), Constants.getAlphabet());
        workWithFiles.setStringsResultFile(finaleListStr);
        workWithFiles.writeFile(finaleListStr);

    }

    @Override
    public List<String> doIter(List<String> stringsFile, char[] alphabet) {
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
            resultStr = switchChars(s, alphabet);
            resultList.add(resultStr);
        }
        return resultList;
    }

    private String switchChars(String str, char[] alphabet) {
        String result;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
//            int num = Arrays.binarySearch(alphabet, chars[i]);
            int num = 0;
            for (int j = 0; j < alphabet.length; j++) {
                if (chars[i] == alphabet[j]) {
                    num = j;
                    break;
                }
            }
            char ch = alphabet[(num + key) % alphabet.length];
            chars[i] = ch;
        }

        result = String.valueOf(chars);
        return  result;
    }
}
