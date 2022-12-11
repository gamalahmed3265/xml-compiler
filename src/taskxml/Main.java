package taskxml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 *
 * @author gamal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        final String path = "C:\\Projects\\Collage\\Forth year\\Compiler Design\\projectsJava\\CompilerDesign\\src\\data/XmlDocument.xml";
        try {
            File file = new File(path);
            if (file.exists()) {
//                System.out.println("exists");

                BufferedReader br
                        = new BufferedReader(new FileReader(file));
                String msg="";
                String st;
                while ((st = br.readLine()) != null)
                    msg+=st+"\n";
//                System.out.println(msg);
                
//                  Lexer
                    StringReader reader = new StringReader(msg);
                    Lexer le=new Lexer(reader);
//                    Token tok;
//                    while((tok = le.getNextToken()).type != TokenType.EOF){
//			System.out.println(tok);
//		}
//                  Parser
                    Parser sp = new Parser(le);
                    sp.Expr();
                    System.out.println("success");
                
            }
            // data base 
//          Student student=new Student("gamal",1,21,"shr");
//          DatabaseClass databaseClass=new DatabaseClass(student);
//          databaseClass.insertData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}

