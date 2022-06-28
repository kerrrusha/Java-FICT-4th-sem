package dataManager;

import java.io.*;

public class IOSerializationUtility {
    public static void serializeObject(Object object, File destinationFile) throws IOException {
        try ( ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(destinationFile)) ) {
            ostream.writeObject(object);
        }
    }

    public static Object deserializeObject(File destinationFile) throws IOException, ClassNotFoundException {
        try ( ObjectInputStream istream = new ObjectInputStream(new FileInputStream(destinationFile)) ) {
            return istream.readObject();
        }
    }
}
