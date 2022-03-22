package ru.javarush.khozhasaitov.cryptoanalyzer.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WorkWithFiles {
    private Path source;
    private Path finaleDirectory;
    private String GETTING_SOURCE = "Введите путь к нативному файлу (.txt): ";
    private String GETTING_FINALE = "Введите путь для создания измененного файла: ";
    private String BAD_PATH = "Не удалось создать файл по указанному пути";
    private String MESSAGE = "Файл с таким именем уже существует, поэтому старый файл будет удален.";
    private String IS_NOT_FILE = "Нет такого файла. Попробуй снова.";
    private String IS_NOT_DIRECTORY = "Указана неверная дирректория или ты думаешь я сам должен ее создать?!\n" +
            "А может ты указал путь к файлу. В любом случае попробуй снова;-)";
    private List<String> stringsFile;
    private List<String> stringsResultFile;


    public void setStringsResultFile(List<String> stringsResultFile) {
        this.stringsResultFile = stringsResultFile;
    }


    public List<String> getStringsFile() {
        return stringsFile;
    }

    public Path getSource() {
        return source;
    }

    public Path getFinaleDirectory() {
        return finaleDirectory;
    }

    public WorkWithFiles() {
        gettingPaths();
    }

    /*
    Метод для работы с файлами. В параметры принимает путь к начальному файлу
    и директорию куда надо сохранить обработанный файл.
    Также проводится валидация правильности пути.
     */
    public void readFile(Path source) {
        try {
            stringsFile = Files.readAllLines(source);

        } catch (IOException e) {
            System.out.println("Ошибка превращения файла в лист строк.");
            e.printStackTrace();
        }
    }

    public void writeFile() {
        for (String s : stringsResultFile) {

            try {
                s = s + "\n";
                Files.write(finaleDirectory, s.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
/*
Метод отвечает за получения пути к начальному файлу и конечному
 */
    private void gettingPaths() {
        System.out.println(GETTING_SOURCE);
        Scanner input = new Scanner(System.in);

        while (true) {
            source = Paths.get(input.nextLine());
            if (Files.isRegularFile(source)) {
                break;
            } else {
                System.out.println(IS_NOT_FILE);

            }
        }

        System.out.println(GETTING_FINALE);
        finaleDirectory = Paths.get(input.nextLine());
        if (Files.notExists(finaleDirectory)) {
            try {
                Files.createFile(finaleDirectory);
            } catch (IOException e) {
                System.out.println(BAD_PATH);
                e.printStackTrace();
            }
        } else {
            System.out.println(MESSAGE);
            try {
                Files.delete(finaleDirectory);
                Files.createFile(finaleDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
