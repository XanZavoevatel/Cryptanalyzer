package ru.javarush.khozhasaitov.cryptoanalyzer.commands;

import java.util.List;
import java.util.Set;

public interface DoIter {
    List<String> doIter(List<String> stringsFile, char[] alphabet, boolean encoder);
    void endWork (boolean encoder);
}


