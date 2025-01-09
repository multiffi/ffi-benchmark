package multiffi.ffi.benchmark;

import multiffi.ffi.Foreign;

import java.io.File;

public final class JNI {

    private JNI() {
        throw new AssertionError("No multiffi.ffi.benchmark.JNI instances for you!");
    }

    static {
        System.load(new File(Foreign.mapLibraryName("benchmark")).getAbsolutePath());
    }

    public static native void return_void();
    public static native int return_int();
    public static native int return_int_i(int value);
    public static native double return_double();
    public static native double return_double_d(double value);

}
