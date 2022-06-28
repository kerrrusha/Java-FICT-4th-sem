package dataManager;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class FileSerializingManager <T> implements DataOperable<T> {
    private final File dataFile;

    public FileSerializingManager() {
        dataFile = new File(".//data.ser");
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
