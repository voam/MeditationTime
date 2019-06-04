package com.meditation.metime.lib;

public class MoodResource {

    private int colorResource;

    private int textResource;

    private String fileName;

    private Class<?> cls;

    private int durationSeconds;

    public MoodResource(int colorResource, int textResource, String fileName, Class<?> cls, int durationSeconds) {

        this.colorResource = colorResource;
        this.textResource = textResource;
        this.fileName = fileName;
        this.cls = cls;
        this.durationSeconds = durationSeconds;

    }

    public Class<?> getClassName() {
        return cls;
    }

    public void setClassName(Class<?> cls) {
        this.cls = cls;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int duration) {
        this.durationSeconds = duration;
    }

    public int getDurationMilliSeconds() {
        return durationSeconds * 1000;
    }

    public int getColorResource() {
        return colorResource;
    }

    public void setColorResource(int colorResource) {
        this.colorResource = colorResource;
    }

    public int getTextResource() {
        return textResource;
    }

    public void setTextResource(int textResource) {
        this.textResource = textResource;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
