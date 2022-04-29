package dataManager;

import java.io.IOException;
import java.util.ArrayList;

public interface IDataOperable <T> {
    ArrayList<T> readAll() throws IOException, ClassNotFoundException;

    void addOne(T object) throws IOException, ClassNotFoundException;
    void addSeveral(ArrayList<T> newObjects) throws IOException, ClassNotFoundException;
}
