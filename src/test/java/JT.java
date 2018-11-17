import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JT {
    public static void main(String[] args) {
      var res=  Stream.of(1).map(m->m+1);
        System.out.println(res.collect(Collectors.toList()));
    }
}
