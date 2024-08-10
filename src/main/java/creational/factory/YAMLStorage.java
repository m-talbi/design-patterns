package creational.factory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class YAMLStorage extends Storage {
    private final Path storageDirectory;
    private String filename;

    public YAMLStorage(Path storageDirectory) {
        this.storageDirectory = storageDirectory;
    }

    @Override
    public Boolean createFile(String filename) {
        var path = Paths.get(storageDirectory.toString(), filename.concat(".yaml"));

        if (Files.exists(path)) {
            return false;
        }

        try {
            Files.createFile(path);
            this.filename = filename;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public void save(String data) {
        if (filename == null) {
            throw new RuntimeException("Filename not set");
        }

        Path filePath = storageDirectory.resolve(filename.concat(".yaml"));

        try {
            Files.writeString(filePath, data, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save data to file: " + filePath, e);
        }
    }

    @Override
    public String loadFile(String filename) {
        Path filePath = storageDirectory.resolve(filename.concat(".yaml"));

        if (!Files.exists(filePath)) {
            throw new RuntimeException("File not found: " + filePath);
        }

        try {
            var data = Files.readString(filePath);
            this.filename = filename;
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Failed to load file: " + filePath, e);
        }
    }

    @Override
    public void delete() {
        if (filename == null) {
            throw new RuntimeException("Filename not set");
        }

        Path filePath = storageDirectory.resolve(filename.concat(".yaml"));

        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete file: " + filePath, e);
        }
    }
}
