package creational.factory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class StorageFactory {
    private final Path storageDirectory;

    public StorageFactory() {
        this(Paths.get(FileSystems.getDefault().getPath("").toAbsolutePath().toString(), "data", "factory"));
    }

    public StorageFactory(String storageDirectoryPath) {
        this(Paths.get(storageDirectoryPath));
    }

    private StorageFactory(Path storageDirectory) {
        this.storageDirectory = ensureDirectoryExists(storageDirectory)
                .orElseThrow(() -> new RuntimeException("Failed to create storage directory: " + storageDirectory));
    }

    private Optional<Path> ensureDirectoryExists(Path directory) {
        try {
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }
            return Optional.of(directory);
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public Storage createStorage(String storageType) {
        return switch (storageType.toLowerCase()) {
            case "yaml" -> new YAMLStorage(storageDirectory);
            default -> new JSONStorage(storageDirectory);
        };
    }

    public Path getStorageDirectory() {
        return storageDirectory;
    }
}
