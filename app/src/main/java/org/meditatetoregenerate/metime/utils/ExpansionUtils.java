package org.meditatetoregenerate.metime.utils;

import android.content.Context;
import android.util.Log;

import java.io.File;

public class ExpansionUtils {

    private static String TAG = "ExpansionUtils";
    public static int MAIN_VERSION = 3;

    /**
     * Here is where you place the data that the validator will use to determine
     * if the file was delivered correctly. This is encoded in the source code
     * so the application can easily determine whether the file has been
     * properly delivered without having to talk to the server. If the
     * application is using LVL for licensing, it may make sense to eliminate
     * these checks and to just rely on the server.
     */
    private static final XAPKFile[] xAPKS = {
            new XAPKFile(
                    true, // true signifies a main file
                    MAIN_VERSION, // the version of the APK that the file was uploaded
                    // against
                    200826237L // the length of the file in bytes
            )
//            ,
//            new XAPKFile(
//                    false, // false signifies a patch file
//                    4, // the version of the APK that the patch file was uploaded
//                    // against
//                    512860L // the length of the patch file in bytes
//            )
    };
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

    /**
     * This is a little helper class that demonstrates simple testing of an
     * Expansion APK file delivered by Market. You may not wish to hard-code
     * things such as file lengths into your executable... and you may wish to
     * turn this code off during application development.
     */
    private static class XAPKFile {
        public final boolean mIsMain;
        public final int mFileVersion;
        public final long mFileSize;

        XAPKFile(boolean isMain, int fileVersion, long fileSize) {
            mIsMain = isMain;
            mFileVersion = fileVersion;
            mFileSize = fileSize;
        }
    }
}
