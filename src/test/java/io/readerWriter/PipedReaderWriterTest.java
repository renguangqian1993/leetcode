package io.readerWriter;

import org.junit.Test;

import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedReaderWriterTest {

    @Test
    public void test() throws Exception {
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();
        reader.connect(writer);

        byte[] bytes = "01234567890abcdefghijklmnopqrstuvwxyz".getBytes();
        for (byte byteTmp : bytes)
            writer.write(byteTmp);

        char[] chars = new char[10];
        int len = reader.read(chars);
        while (len > -1) {
            System.out.println(String.valueOf(chars, 0, len));
            len = reader.read(chars);//此处会出不来，必须有多少取多少，否则会一直等待下去
        }


    }

}
