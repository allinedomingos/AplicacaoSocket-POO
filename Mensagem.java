
package questao5;

import java.io.Serializable;
/**
 *
 * @author alline
 */
public class Mensagem implements Serializable {

 private String numPrimo;
 private String Usuario;
 private String respostaServer;

    Mensagem(String user, String numero) {
        
        this.numPrimo = numero;
        this.Usuario = user;
    }

    String getResposta() {
         return respostaServer;
       
    }
    public void setResposta(String resposta) {
        this.respostaServer = resposta;
    }
  
     public String getNumero() {
        return numPrimo;
    }

    public void setNumero(String numeroId) {
        this.numPrimo = numeroId;
    }

    public String getId_user() {
        return Usuario;
    }

    public void setDestino(String user) {
        this.Usuario = user;
    }


  
    
}
