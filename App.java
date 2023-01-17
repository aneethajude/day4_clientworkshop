package sg.edu.nus.iss;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws IOException
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        //do{    
        Socket socket = new Socket("localhost",7000);
            OutputStream os = socket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            Console con = System.console();
            String readInput = "";
            String receivedMessaged ="";

            do{
                readInput = con.readLine("Enter a command to execute ");
                dos.writeUTF(readInput);
                dos.flush();
                
                
            }while(!readInput.equalsIgnoreCase("Close"));
         
      
      if(readInput.equalsIgnoreCase("Close")){
        
       socket.close();}
            // dis.close();
            // bis.close();
            // is.close();
    }
}

