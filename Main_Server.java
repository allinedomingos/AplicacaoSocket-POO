
package questao5;

/**
 *
 * @author alline
 */
public class Main_Server {
    
    
     public static void main(String[] args) {
        Thread server = new Thread(new Server());
        server.start();
    }
}
