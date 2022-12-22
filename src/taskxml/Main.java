package taskxml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 *
 * @author gamal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        final String path = "C:\\Projects\\Collage\\Forth year\\Compiler Design\\projectsJava\\TaskXml\\src\\data\\data.xml";
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
//                    StringReader reader = new StringReader(msg);
//                    Lexer le=new Lexer(reader);

                    StringReader reader = new StringReader(msg);
                    SimpleLexer le=new SimpleLexer(reader);
//                    Token tok;
//                    while((tok = le.getNextToken()).type != TokenType.EOF){
//			System.out.println(tok);
//		}
//                  Parser
//                    Parser sp = new Parser(le);
//                    sp.Expr();
//                    System.out.println("success");
//                                  Parser

                  SimpleParser sp=new SimpleParser(le);
                  TableData tableData=sp.Expr();
                  System.out.println("*************");
//                  System.out.println("tableData: "+ tableData);
                  
                  for (int i = 0; i < tableData.rowOfTable.size(); i++) {
                    if(tableData.rowOfTable.get(i).student.getId()!=0) {
//                         System.out.println("id: "+ tableData.rowOfTable.get(i).student.getId());
//                        System.out.println("names: "+ tableData.rowOfTable.get(i).student.getName());
//                        System.out.println("age: "+ tableData.rowOfTable.get(i).student.getAge());
//                        System.out.println("phone: "+ tableData.rowOfTable.get(i).student.getPhone());
                        
                        
                        int id= tableData.rowOfTable.get(i).student.getId();
                        String name=tableData.rowOfTable.get(i).student.getName();
                        int age= tableData.rowOfTable.get(i).student.getAge();
                        int phone= tableData.rowOfTable.get(i).student.getPhone();
                        
                        Student student=new Student(name, id, age, phone);
                        DatabaseClass databaseClass=new DatabaseClass(student);
                        databaseClass.insertData();
                  }
                  }
                   System.out.println("*************");
                  System.out.println("success");


            }
//                    AST.Exper root = p.S();
//        System.out.println("Equation = " + root.toString());
//        System.out.println("result = " + root.evaluate());

            
            // data base 
//          Student student=new Student("gamal",1,21,"shr");
//          DatabaseClass databaseClass=new DatabaseClass(student);
//          databaseClass.insertData();
//            System.out.println("good");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}

