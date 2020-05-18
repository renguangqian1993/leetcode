package io.readerWriter;

import io.stream.FileStreamTest;
import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderWriterTest {

    @Test
    public void writerTest() throws Exception {
        String str = "0123456789abcdefghijklmnopqrstuvwxyz";
        char[] chars = str.toCharArray();
        byte[] bytes = str.getBytes();

        FileWriter writer = new FileWriter(FileStreamTest.filePath);
        for (int index = 0; index < str.length(); index++) {
            if (index % 2 == 0) {
                writer.write(bytes[index]);
            } else {
                writer.append(chars[index]);
            }
        }

        writer.flush();
        writer.close();
    }

    @Test
    public void readerTest() throws Exception {
        FileReader reader = new FileReader(FileStreamTest.filePath);

        char[] chars = new char[10];
        int len;
        while ((len = reader.read(chars)) > 0) {
            System.out.print(String.valueOf(chars, 0, len));
        }
        System.out.println("...end...");
        reader.close();
    }

}
