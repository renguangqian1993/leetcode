package io.stream;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedStreamTest {


    @Test
    public void inputStreamTest() throws Exception {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(FileStreamTest.filePath));

        System.out.println(inputStream.available());
        System.out.println(inputStream.markSupported());
        System.out.println(inputStream.read());
        System.out.println(inputStream.available());

        inputStream.mark(0);
        System.out.println(inputStream.read());
        System.out.println(inputStream.available());
        System.out.println(inputStream.skip(2));
        System.out.println(inputStream.available());
        System.out.println(inputStream.read());

        inputStream.reset();
        System.out.println(inputStream.available());
        System.out.println(new String(inputStream.readAllBytes()));
    }

    @Test
    public void outputStreamTest() throws Exception {
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(FileStreamTest.filePath, true), 1);

        for (byte byteTmp = 48; byteTmp <= 57; byteTmp++) {
            outputStream.write(byteTmp);
        }

        outputStream.flush();
        outputStream.close();
    }
}
