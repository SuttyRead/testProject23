package com.ua.sutty.lab8;

import interfaces.task8.SerializableUtils;

import java.io.*;

public class SerializableUtilsImpl implements SerializableUtils, Serializable {

    @Override
    public void serialize(OutputStream outputStream, Object o) {
        if (outputStream == null || o == null) {
            throw new NullPointerException("Don't have necessary argument");
        }
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(
                outputStream);
            objectOut.writeObject(o);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object deserialize(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException("Argument is null");
        }
        try {
            ObjectInputStream objectIn = new ObjectInputStream(inputStream);
            return objectIn.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
