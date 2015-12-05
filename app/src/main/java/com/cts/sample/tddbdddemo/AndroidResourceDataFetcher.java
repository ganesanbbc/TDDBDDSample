package com.cts.sample.tddbdddemo;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AndroidResourceDataFetcher {

    private final int targetResource;
    private final Context context;

    public AndroidResourceDataFetcher(Context context, int targetResource) {
        this.context = context;
        this.targetResource = targetResource;
    }

    public byte[] fetch() {

        InputStream rawResource = context.getResources().openRawResource(targetResource);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        int read = 0;
        byte[] buffer = new byte[4096];
        try {
            while ((read = rawResource.read(buffer)) > 0) {
                bout.write(buffer, 0, read);
            }

            return bout.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}