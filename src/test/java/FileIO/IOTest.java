package FileIO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class IOTest {
    public static void main(String[] args) throws FileNotFoundException {
        var bfi = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\wsgpz\\IdeaProjects\\canvas\\protoFile\\III21514192269561.tar.gz")));

    }
}
