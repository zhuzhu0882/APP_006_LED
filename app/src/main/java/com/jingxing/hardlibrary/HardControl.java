package com.jingxing.hardlibrary;

public class HardControl {
    public static native int LedCtrl(int which, int status);
    public static native int ledOpen();
    public static native void LedClose();

    static {
        try {
            System.loadLibrary("hardcontrol");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
