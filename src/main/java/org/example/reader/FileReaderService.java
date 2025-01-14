package org.example.reader;

import java.io.IOException;
import java.util.List;

public interface FileReaderService {
    List<Character> readFile(String filePath) throws IOException;
}

