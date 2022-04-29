package dataManager;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;

public class FileSerializingManager <T> implements IDataOperable<T> {
    private final File dataFile;

    public FileSerializingManager(String filePath) throws IOException {
        dataFile = new File(filePath);
        connect();
    }
    private void connect() throws IOException {
        if (!dataFile.exists())
            if(!dataFile.createNewFile())
                throw new FileSystemException("Cannot find and create such file:\t" + dataFile);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<T> readAll() throws IOException, ClassNotFoundException {
        try {
            return (ArrayList<T>) IOSerializationUtility.deserializeObject(dataFile);
        }
        catch (EOFException eof) {
            return new ArrayList<T>();
        }
    }

    @Override
    public void addOne(T object) throws IOException, ClassNotFoundException {
        ArrayList<T> objects = readAll();
        objects.add(object);
        IOSerializationUtility.serializeObject(objects, dataFile);
    }

    @Override
    public void addSeveral(ArrayList<T> newObjects) throws IOException, ClassNotFoundException {
        ArrayList<T> objects = readAll();
        objects.addAll(newObjects);
        IOSerializationUtility.serializeObject(objects, dataFile);
    }

    public String getFilePath() {
        return dataFile.getPath();
    }
}
