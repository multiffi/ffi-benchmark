package multiffi.ffi.benchmark;

import multiffi.ffi.CallOption;
import multiffi.ffi.SimpleCallOptionVisitor;
import multiffi.ffi.StandardCallOption;

import java.lang.reflect.Method;

public interface MultiffiLibrary {
    MultiffiLibrary INSTANCE_FFM = Multiffi.FFM.downcallProxy(MultiffiLibrary.class);
    MultiffiLibrary INSTANCE_FFM_CRITICAL = Multiffi.FFM.downcallProxy(MultiffiLibrary.class, new SimpleCallOptionVisitor() {
        @Override
        public CallOption[] visitCallOptions(Method method) {
            return new CallOption[] { StandardCallOption.TRIVIAL };
        }
    });
    MultiffiLibrary INSTANCE_JNA = Multiffi.JNA.downcallProxy(MultiffiLibrary.class);
    MultiffiLibrary INSTANCE_JNA_NOASM = Multiffi.JNA_NOASM.downcallProxy(MultiffiLibrary.class);
    MultiffiLibrary INSTANCE_JNR = Multiffi.JNR.downcallProxy(MultiffiLibrary.class);
    MultiffiLibrary INSTANCE_JNR_NOASM = Multiffi.JNR_NOASM.downcallProxy(MultiffiLibrary.class);

    void return_void();
    int return_int();
    int return_int_i(int value);
    double return_double();
    double return_double_d(double value);
}
