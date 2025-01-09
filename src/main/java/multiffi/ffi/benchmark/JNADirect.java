package multiffi.ffi.benchmark;

import com.sun.jna.Native;
import multiffi.ffi.Foreign;

import java.io.File;

public final class JNADirect {

    private JNADirect() {
        throw new AssertionError("No multiffi.ffi.benchmark.JNADirect instances for you!");
    }

    static {
        Native.register(JNADirect.class, new File(Foreign.mapLibraryName("benchmark")).getAbsolutePath());
    }

    public static native void return_void();
    public static native int return_int();
    public static native int return_int_i(int value);
    public static native double return_double();
    public static native double return_double_d(double value);

}
