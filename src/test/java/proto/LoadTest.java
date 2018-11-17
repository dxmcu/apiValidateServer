package proto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoadTest {
    public static void main(String[] args) {
        try {
            FileOutputStream output = new FileOutputStream("C:\\Users\\wsgpz\\IdeaProjects\\canvas\\target\\outproc");

            var gg = SimpleProc.Person.newBuilder();
            gg.setEmail("lala").setId(666).setName("2").build();
            //?
            gg.mergeFrom(new FileInputStream("C:\\Users\\wsgpz\\IdeaProjects\\canvas\\target\\outproc"));
            gg.build().writeTo(output);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            var gg = SimpleProc.Person.parseFrom(new FileInputStream("C:\\Users\\wsgpz\\IdeaProjects\\canvas\\target\\outproc"));
            System.out.println(gg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
