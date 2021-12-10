import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Box implements Serializable {
    static final long serialVersionUID = 1L;
    private int a;
    private List<String> l = new ArrayList<>();

    public Box(final int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public List<String> getL() {
        return l;
    }

    public static void save(Serializable obj, String filename) {
        try {
            final var fileOutputStream = new FileOutputStream(filename);
            final var objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
        } catch(FileNotFoundException fnfe) {
            System.out.println("Ficheiro inexistente.");
        } catch(IOException ioe) {
            System.out.println("Erro na gravação de objetos.");
        }
    }

    public static Object load(String filename) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filename);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch(IOException e) {
            e.printStackTrace();
        }
        Object obj = null;
        try {
            obj = objectInputStream.readObject();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) {
//        Box box = new Box(42);
//        box.getL().add("First");
//        box.getL().add("Second");
//        box.getL().add("Third");
//
//        System.out.println(box.getA());
//        for(final var s : box.getL()) {
//            System.out.println(s);
//        }
//        save(box, "obj.save");
        Object obj = load("obj.save");
        Box box2 = null;
        if(obj instanceof  Box) {
            box2 = (Box)obj;
        }

        System.out.println(box2.getA());
        for(final var s : box2.getL()) {
            System.out.println(s);
        }
    }

}
