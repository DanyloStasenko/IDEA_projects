cmake_minimum_required(VERSION 3.6)
project(lab4)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

set(SOURCE_FILES main.cpp stack.h)
add_executable(lab4 ${SOURCE_FILES})