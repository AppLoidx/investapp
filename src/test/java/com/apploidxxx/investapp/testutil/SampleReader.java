package com.apploidxxx.investapp.testutil;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;

public final class SampleReader {
    private SampleReader() {}

    @SneakyThrows
    public static String readSample(String name) {
        return Files.readString(new File("src/test/resources/samples/" + name).toPath());
    }
}
