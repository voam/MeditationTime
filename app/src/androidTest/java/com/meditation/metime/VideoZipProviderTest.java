package com.meditation.metime;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import com.meditation.metime.providers.VideoZipProvider;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class VideoZipProviderTest {

    private String TAG = getClass().getSimpleName();
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context context = InstrumentationRegistry.getTargetContext();

        String fileName = "one.mp4";
        Uri uri= VideoZipProvider.buildUri(fileName);
        Log.i(TAG, uri.toString());
        //videoView.SetVideoUri(uri);

        //videoView.setVideoUri(uri);


//        ZipFileContentProvider contentProvider = new ZipFileContentProvider();
//        String contentPath = "content://";
//        File root = Environment.getExternalStorageDirectory();
//        String EXP_PATH = File.separator + "Android" + File.separator + "obb" + File.separator;
//        String path = root.toString() + EXP_PATH + context.getPackageName() + File.separator + "main.1.com.c4e1.in2cricket.obb";
//        String zipFileName =  contentPath + path + "/" + fileName;
//        Uri uri = Uri.parse(zipFileName);
//        videoView.setVideoUri(uri);

    }
}
