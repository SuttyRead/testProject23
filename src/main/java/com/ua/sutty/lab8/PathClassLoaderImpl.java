package com.ua.sutty.lab8;

import com.sun.org.apache.bcel.internal.util.ClassLoader;
import interfaces.task8.PathClassLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClassLoaderImpl extends ClassLoader implements PathClassLoader {

    private String path = "./";

    @Override
    public void setPath(String path) {
        if (path == null) {
            throw new NullPointerException();
        }
        this.path = path;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        URL url = null;
        try {
            Path path = Paths.get(this.path);
            url = path.toUri().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URL[] urls = new URL[] {url};
        URLClassLoader loader = new URLClassLoader(urls);
        return loader.loadClass(name);
    }
}

