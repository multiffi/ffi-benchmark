#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

#if defined(WIN32) || defined(_WIN32) || defined(__WIN32) || defined(__WIN32__)
#ifdef __GNUC__
#define export __attribute__ ((dllexport)) extern
#else
#define export __declspec (dllexport)
#endif
#elif defined(__GNUC__) && __GNUC__ >= 4
#define export extern __attribute__ ((visibility ("default")))
#else
#define export extern
#endif

export void return_void() {
    return;
}

export int return_int() {
    return 0;
}

export int return_int_i(int value) {
    return value;
}

export double return_double() {
    return 0;
}

export double return_double_d(double value) {
    return value;
}

JNIEXPORT void JNICALL Java_multiffi_ffi_benchmark_JNI_return_1void (JNIEnv *env, jclass clazz) {
    return_void();
}

JNIEXPORT jint JNICALL Java_multiffi_ffi_benchmark_JNI_return_1int (JNIEnv *env, jclass clazz) {
    return return_int();
}

JNIEXPORT jint JNICALL Java_multiffi_ffi_benchmark_JNI_return_1int_1i (JNIEnv *env, jclass clazz, jint value) {
    return return_int_i(value);
}

JNIEXPORT jdouble JNICALL Java_multiffi_ffi_benchmark_JNI_return_1double (JNIEnv *env, jclass clazz) {
    return return_double();
}

JNIEXPORT jdouble JNICALL Java_multiffi_ffi_benchmark_JNI_return_1double_1d (JNIEnv *env, jclass clazz, jdouble value) {
    return return_double_d(value);
}

#ifdef __cplusplus
}
#endif
