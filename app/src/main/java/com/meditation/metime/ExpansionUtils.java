package com.meditation.metime;

import android.content.Context;
import android.util.Log;

import java.io.File;

public class ExpansionUtils {

    private static String TAG = "ExpansionUtils";
    public static int MAIN_VERSION = 1;
    public static Boolean ExpansionFilesExist(Context ctx) {

        Boolean exists = false;
        File f  = ctx.getObbDir();

        String fileName = String.format("main.%d.%s.obb", MAIN_VERSION, ctx.getPackageName());
//        //         main.314159.com.example.app.obb
//        String filePathToMyZip = this.getObbDir().toString() + fileName;
        String fullPath = f.getPath() + File.separator + fileName;
        Log.i(TAG, "Testing for path" + fullPath);
        File obb = new File(fullPath);
        exists = obb.exists();

        return exists;

    }
}
