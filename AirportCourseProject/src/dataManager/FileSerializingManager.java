package dataManager;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class FileSerializingManager <T> implements IDataOperable<T> {
    private final File dataFile;
    final String dataFileAddress = ".//data.ser";

    public FileSerializingManager() throws IOException {
        dataFile = new File(dataFileAddress);
        connect();
    }
    private void connect() throws IOException {
        dataFile.exists();
        dataFile.createNewFile();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> readAll() throws IOException, ClassNotFoundException {
        try {
            return (List<T>) IOSerializationUtility.deserializeObject(dataFile);
        }
        catch (EOFException eof) {
            return Collections.emptyList();
        }
    }

    @Override
    public void addOne(T object) throws IOException, ClassNotFoundException {
        List<T> objects = readAll();
        objects.add(object);
        IOSerializationUtility.serializeObject(objects, dataFile);
    }

    @Override
    public void addSeveral(List<T> newObjects) throws IOException, ClassNotFoundException {
        List<T> objects = readAll();
        objects.addAll(newObjects);
        IOSerializationUtility.serializeObject(objects, dataFile);
    }
}
