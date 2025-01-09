package multiffi.ffi.benchmark;

import jnr.ffi.LibraryLoader;
import jnr.ffi.annotations.IgnoreError;
import jnr.ffi.provider.jffi.NoX86;
import multiffi.ffi.Foreign;

import java.io.File;

@NoX86
public interface JFFILibrary {
    JFFILibrary INSTANCE = LibraryLoader.create(JFFILibrary.class).load(new File(Foreign.mapLibraryName("benchmark")).getAbsolutePath());

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
