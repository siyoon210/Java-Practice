package my.examples.was;

;
import java.util.Map;
import java.util.Set;

public class ClassFinderTester {

    public static void main(String[] args) {
        String baseDir = "/home/siyoon/Documents/Java-Practice/MAVEN/miniwas/target/classes/";
        WebServletMapperManager wsmm = new WebServletMapperManager();
        Map<String, Class> map = wsmm.findServlet(baseDir);
        Set<String> paths = map.keySet();
        for(String path : paths){
            System.out.println(path + " : " + map.get(path).getName());
        }
    }

}
