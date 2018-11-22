package com.ua.sutty.lab8;

import com.sun.org.apache.bcel.internal.util.ClassLoader;
import interfaces.task8.PathClassLoader;

import java.io.*;

public class PathClassLoaderImpl extends ClassLoader implements PathClassLoader {

    private String path;

    public PathClassLoaderImpl() {
    }

    @Override public String getPath() {
        return path == null ? "" : path;
    }

    @Override public void setPath(String dir) {
        if (dir == null){
            throw new NullPointerException();
        }
        path = dir;
    }

    @Override public Class<?> loadClass(String name)
        throws ClassNotFoundException {
        if (!name.startsWith("java")) {

            String fullName =
                name.replace('.', File.separatorChar) + ".class";
            try (InputStream inputStream = new FileInputStream(
                path + "/" + fullName)) {
                byte[] b = new byte[inputStream.available()];
                DataInputStream dataInputStream = new DataInputStream(
                    inputStream);
                dataInputStream.readFully(b);

                Class c = defineClass(name, b, 0, b.length);
                resolveClass(c);
                return c;
            } catch (NullPointerException | IOException e) {
                throw new ClassNotFoundException();
            }
        }
        return super.loadClass(name);
    }
}

