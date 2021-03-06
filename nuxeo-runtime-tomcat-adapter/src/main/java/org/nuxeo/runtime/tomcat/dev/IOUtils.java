package org.nuxeo.runtime.tomcat.dev;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class IOUtils {

      public static void deleteTree(File dir) {
        for (File file:dir.listFiles()) {
            if (file.isDirectory()) {
                deleteTree(file);
            } else {
                file.delete();
            }
        }
        dir.delete();
    }

    public static void copyTree(File source, File target) throws IOException {
        if (source.isDirectory()) {
            if (!target.exists()) {
                target.mkdir();
            }
            for (File child:source.listFiles()) {
                copyTree(child, new File(target, child.getName()));
            }
        } else {
            copyContent(new FileInputStream(source), new FileOutputStream(target));
        }
    }
    
    public static void copyContent(InputStream is, OutputStream out) throws IOException {
        int data;
        while(is.available() > 0  && (data = is.read()) != -1) {
            out.write(data);
        }
    }
    
    public static void appendResourceBundleFragments(String name,
            List<File> files, File target) throws IOException {
        File l10n = new File(target, name);
        File backup = new File(target, name + "~bak");
        if (!backup.exists()) {
            backup.createNewFile();
            IOUtils.copyContent(new FileInputStream(l10n),
                    new FileOutputStream(backup));
        }
        IOUtils.copyContent(new FileInputStream(backup), new FileOutputStream(
                l10n));
        for (File file : files) {
            InputStream in = new FileInputStream(file);
            OutputStream out = new FileOutputStream(l10n, true);
            IOUtils.copyContent(in, out);
        }
    }

    }
