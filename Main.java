import org.labs1.SimpleUrl;


public class Main {
    public static void main (String[] args) {
        String url = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";
        SimpleUrl simpleUrl = new SimpleUrl(url);
        System.out.println(simpleUrl);
    }
}
