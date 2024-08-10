package creational.factory;

import java.nio.file.Path;

public abstract class Storage {

    public abstract Boolean createFile(String filename);

    public abstract void save(String data);

    public abstract String loadFile(String filename);

    public abstract void delete();
}
