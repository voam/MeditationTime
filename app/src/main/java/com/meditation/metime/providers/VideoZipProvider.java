package com.meditation.metime.providers;

import android.net.Uri;

import com.android.vending.expansion.zipfile.APEZProvider;

import java.io.File;

/**
 *  MeDitationTime
 *
 *  VideoZipProvider.class: Provider for reading zipped video files inside an expansion zip file
 *
 *  This link was useful http://nullpointerexc.blogspot.com/2014/05/android-read-media-file-from-obb-using.html
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

public class VideoZipProvider extends APEZProvider {

    private static final String AUTHORITY = "com.meditation.metime.provider";
    @Override
    public String getAuthority() {
        return AUTHORITY;
    }

    public static Uri buildUri(String path) {

        StringBuilder contentPath = new StringBuilder("content://");
        contentPath.append(AUTHORITY);
        contentPath.append(File.separator);
        contentPath.append(path);
        return Uri.parse(contentPath.toString());
    }
}
