package cw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReading {

    ArrayList<String> file = new ArrayList<>();
    ArrayList<String> fullFile = new ArrayList<>();
    String[] columns;
    
    FileReading() {

    }

    public void readTextFile(String userChoice) {
        String dir = System.getProperty("user.dir");
        File fileName = new File(dir + "//data.txt");
        String line;

        if ((fileName == null) || (fileName.equals(""))) {
            System.out.println("No file name specified.");
        } else {
            try {
                BufferedReader in = new BufferedReader(new FileReader(fileName));

                if (!in.ready()) {
                    throw new IOException();
                }

                int colValue = 0;
                while ((line = in.readLine()) != null) {
                    fullFile.add(line);
                    columns = line.split("\t");
                    for (int i = 0; i < columns.length; i++) {
                        if (columns[i].contains(userChoice)) {
                            colValue = i;
                            break;
                        }
                    }
                    file.add(columns[colValue]);
                    //System.out.println(file);
                }
                in.close();
            } catch (IOException e) {
                System.out.println(e);
                file.add("File not found");
            }
        }
    }

    public ArrayList<String> getFullTextFile() {
        return fullFile;
    }

    public ArrayList<String> getTextFile() {
        return file;
    }

}
