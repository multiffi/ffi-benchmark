package multiffi.ffi.benchmark;

import com.sun.jna.Library;
import com.sun.jna.Native;
import multiffi.ffi.Foreign;

import java.io.File;

public interface JNALibrary extends Library {
    JNALibrary INSTANCE = Native.load(new File(Foreign.mapLibraryName("benchmark")).getAbsolutePath(), JNALibrary.class);

    void return_void();
    int return_int();
    int return_int_i(int value);
    double return_double();
    double return_double_d(double value);
}
