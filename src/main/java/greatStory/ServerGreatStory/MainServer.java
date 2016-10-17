package greatStory.ServerGreatStory;

/**
 * Created by Onlin on 12.10.2016.
 */
public class MainServer {

    public static void main(String[] args) {

ServerGreatStory serverGreatStory =new ServerGreatStory(8585);
        serverGreatStory.start();
//        ClientGreatStory client1 = new ClientGreatStory(8585);
//        client1.start();
//        client1.setName("client 1");
//        ClientGreatStory client2 = new ClientGreatStory(8585);
//        client2.start();
//        client2.setName("client 2");
//        ClientGreatStory client3 = new ClientGreatStory(8585);
//        client3.start();
//        client3.setName("client 3");
    }
}
