package com.digitalsmartsoil.app.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtils {
    
    public static Bitmap compressImage(Bitmap bitmap, int quality) {
        return bitmap;
    }

    public static Bitmap resizeImage(Bitmap bitmap, int targetWidth, int targetHeight) {
        return Bitmap.createScaledBitmap(bitmap, targetWidth, targetHeight, true);
    }

    public static File saveImageToFile(Bitmap bitmap, String filePath, int quality) throws IOException {
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        
        FileOutputStream fos = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fos);
        fos.flush();
        fos.close();
        
        return file;
    }

    public static Bitmap loadImageFromFile(String filePath) {
        return BitmapFactory.decodeFile(filePath);
    }
}
