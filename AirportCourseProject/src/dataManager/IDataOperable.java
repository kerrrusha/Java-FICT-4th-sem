package dataManager;

import java.io.IOException;
import java.util.List;

public interface IDataOperable <T> {
    List<T> readAll() throws IOException, ClassNotFoundException;

    void addOne(T object) throws IOException, ClassNotFoundException;
    void addSeveral(List<T> newObjects) throws IOException, ClassNotFoundException;
}
