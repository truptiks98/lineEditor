package com.lineeditor.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.lineeditor.base.IEditor;

public class TextEditor implements IEditor {
    private List<String> lines;
    private String filePath;

    public TextEditor(String filePath) throws IOException {
        this.filePath = filePath;
        this.lines = new ArrayList<>(Files.readAllLines(Paths.get(filePath)));
    }

    @Override
    public void list() {
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }
    }

    @Override
    public void delete(int lineNumber) {
        if (lineNumber >= 1 && lineNumber <= lines.size()) {
            lines.remove(lineNumber - 1);
        } else {
            System.out.println("Invalid line number");
        }
    }

    @Override
    public void insert(int lineNumber, String lineContent) {
        if (lineNumber >= 1 && lineNumber <= lines.size() + 1) {
            lines.add(lineNumber - 1, lineContent);
        } else {
            System.out.println("Invalid line number");
        }
    }

    @Override
    public void save() throws IOException {
        Files.write(Paths.get(filePath), lines);
    }

    @Override
    public void quit() {
        System.out.println("Quiting editor.");
    }
}

