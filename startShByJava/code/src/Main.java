import java.io.IOException;

/**
 * @author XUAN
 * @date 2021/3/19 - 12:09
 * @references
 * @purpose
 * @errors
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String shpath = "/tmp/test.sh";   //程序绝对路径
        String command1 = "chmod 777 " + shpath;
        Runtime.getRuntime().exec(command1);

        Runtime.getRuntime().exec(shpath);
    }
}
