package ru.javarush.khozhasaitov.cryptoanalyzer.constants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Constants {
    private static final char[] ALPHABET = {' ', '\n', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и','й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ю',
            'ъ', 'ы', 'ь', 'э', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И','Й', 'К', 'Л', 'М', 'Н',
            'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ю','Ъ', 'Ы', 'Э', 'Я', '.', ',', '«', '»',
            '"', '\'', ':', '!', '?',  '-', '_', '(', ')' , '1','2','3','4','5', '6','7','8','9','0', '[', ']'};

    public static char[] getAlphabet() {
        return ALPHABET;
    }
}
