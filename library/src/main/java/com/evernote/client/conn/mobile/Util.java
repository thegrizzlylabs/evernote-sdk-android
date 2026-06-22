package com.evernote.client.conn.mobile;

import java.io.Closeable;

public class Util {
    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception ignored) {
        }
    }
}
