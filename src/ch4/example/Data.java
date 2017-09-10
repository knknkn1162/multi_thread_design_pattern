package ch4.example;

/**
 * Created by knknkn on 2017/09/10.
 */

import java.io.IOException;
import java.io.FileWriter;

import java.io.Writer;

public class Data {
    private final String filename;
    private String content;
    private boolean changed;

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    public synchronized void save() throws IOException {
        // if unchanged, balk
        if (!changed) { return;}
        doSave();
        changed=false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls dosave, content = "+ content);

        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
