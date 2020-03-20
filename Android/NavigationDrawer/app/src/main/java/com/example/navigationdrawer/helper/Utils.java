package com.example.navigationdrawer.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class Utils {
    public static byte[] getBytes(Bitmap userImage){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        userImage.compress(Bitmap.CompressFormat.PNG, 0,stream);
        return stream.toByteArray();
    }

    public static Bitmap getImage(byte[] data){
        return BitmapFactory.decodeByteArray(data, 0, data.length);
    }
}
