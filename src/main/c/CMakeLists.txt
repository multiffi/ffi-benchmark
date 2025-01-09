cmake_minimum_required(VERSION 3.24)

project(benchmark C)

set(CMAKE_C_STANDARD 99)

find_package(JNI REQUIRED)

add_library(benchmark SHARED benchmark.c)
target_link_libraries(benchmark PRIVATE JNI::JNI)
