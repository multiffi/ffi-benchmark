package multiffi.ffi.benchmark;

import io.github.multiffi.ffi.FFMForeignProvider;
import io.github.multiffi.ffi.JNAForeignProvider;
import io.github.multiffi.ffi.JNRForeignProvider;
import multiffi.ffi.Foreign;
import multiffi.ffi.spi.ForeignProvider;

import java.io.File;

public final class Multiffi {

    private Multiffi() {
        throw new AssertionError("No multiffi.ffi.benchmark.Multiffi instances for you!");
    }

    public static final ForeignProvider DEFAULT = ForeignProvider.getImplementation();
    public static final ForeignProvider FFM = DEFAULT instanceof FFMForeignProvider ? DEFAULT : new FFMForeignProvider();
    public static final ForeignProvider JNA = DEFAULT instanceof JNAForeignProvider ? DEFAULT : new JNAForeignProvider();
    public static final ForeignProvider JNR = DEFAULT instanceof JNRForeignProvider ? DEFAULT : new JNRForeignProvider();
    public static final ForeignProvider FFM_NOASM = new FFMForeignProvider(false);
    public static final ForeignProvider JNA_NOASM = new JNAForeignProvider(false);
    public static final ForeignProvider JNR_NOASM = new JNRForeignProvider(false);

    static {
        FFM.loadLibrary(new File(Foreign.mapLibraryName("benchmark")));
        FFM_NOASM.loadLibrary(new File(Foreign.mapLibraryName("benchmark")));
        JNA.loadLibrary(new File(Foreign.mapLibraryName("benchmark")));
        JNA_NOASM.loadLibrary(new File(Foreign.mapLibraryName("benchmark")));
        JNR.loadLibrary(new File(Foreign.mapLibraryName("benchmark")));
        JNR_NOASM.loadLibrary(new File(Foreign.mapLibraryName("benchmark")));
    }

}
