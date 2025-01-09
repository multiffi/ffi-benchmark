package multiffi.ffi.benchmark;

import jnr.ffi.LibraryLoader;
import jnr.ffi.annotations.IgnoreError;
import multiffi.ffi.Foreign;

import java.io.File;

public interface JNRLibrary {
    JNRLibrary INSTANCE = LibraryLoader.create(JNRLibrary.class).load(new File(Foreign.mapLibraryName("benchmark")).getAbsolutePath());

    @IgnoreError
    void return_void();
    @IgnoreError
    int return_int();
    @IgnoreError
    int return_int_i(int value);
    @IgnoreError
    double return_double();
    @IgnoreError
    double return_double_d(double value);
}
