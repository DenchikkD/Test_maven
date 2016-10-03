import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.HashMap;

/**
 * Created by Denni on 10/3/2016.
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer>map=new HashMap<>();
        System.out.println(map.put(1,1));
        System.out.println(map.put(1,1));
        System.out.println(map.put(1,2));
        System.out.println(map);

    }
}
