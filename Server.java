
package questao5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alline
 */
public class Server implements Runnable {
     
    private static Socket s; //Create Socket
    private static ServerSocket ss;//Create a Server Socket
    

    
    @Override
    public void run() {
        
        int num;
        
        try {
            ss = new ServerSocket(2800);//Start a new server socket on port 2800
            System.out.println("Aguardando mensagem");
            while(true){
                s = ss.accept();//Accept when a request arrives
               
                ObjectInputStream requestfromClient = new ObjectInputStream(s.getInputStream());
                Mensagem m1 = (Mensagem) requestfromClient.readObject();
                num = Integer.valueOf(m1.getNumero());
                    
                                 
                int contador = 0;
                for (int i=1;i<=num;i++ ){
                     if(num % i == 0){
                     contador = contador + 1;
                  }
                       
                     //System.out.println("passei aqui");
                }
              
                    if (contador == 2){
                        m1.setResposta("OK!");
                        System.out.println("O número  "+ num  + "  é primo!");
                    }else{
                        m1.setResposta("NOT!");
                        System.out.println("O número  " +  num  +" não é primo!");
                    }   
                    // System.out.println("aqui tbm");
                    
                    ObjectOutputStream replyObjectToClient = new ObjectOutputStream(s.getOutputStream());
                                    
                    replyObjectToClient.writeObject(m1);
      
                 
                    
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
