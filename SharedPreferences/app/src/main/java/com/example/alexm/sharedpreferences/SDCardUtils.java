package com.example.alexm.sharedpreferences;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by alexm on 19/05/2017.
 */

public class SDCardUtils {

    private static final String TAG = SDCardUtils.class.getName();

    public static File getSdCardFile(String dirName, String fileName){
        File sdCard = android.os.Environment.getExternalStorageDirectory();
        File dir = new File(sdCard, dirName);
        if(!dir.exists()){
            dir.mkdir();
        }
        File file = new File(dir,fileName);
        return file;
    }

    public static File writeToCard(File f, byte[] bytes){
        try{
            if(f != null){
                FileOutputStream out = new FileOutputStream(f);
                out.write(bytes);
                out.close();
            }
        }catch (FileNotFoundException e){
            Log.e(TAG, e.getMessage(), e);
        }catch (IOException e){
            Log.e(TAG, e.getMessage(), e);
        }
        return f;
    }
}
