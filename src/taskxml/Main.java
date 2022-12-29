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

    public static void main(String[] args) throws IOException {
        final String path = "C:\\Projects\\Collage\\Forth year\\Compiler Design\\projectsJava\\TaskXml\\src\\data\\data.xml";
        try {
            File file = new File(path);
            if (file.exists()) {

                BufferedReader br
                        = new BufferedReader(new FileReader(file));
                String msg = "";
                String st;
                while ((st = br.readLine()) != null) {
                    msg += st + "\n";
                }
                StringReader reader = new StringReader(msg);
                SimpleLexer le = new SimpleLexer(reader);

                SimpleParser sp = new SimpleParser(le);
                TableData tableData = sp.Expr();
                System.out.println("*************");
                
                
                for (int i = 0; i < tableData.rowOfTable.size(); i++) {
                    int id = tableData.rowOfTable.get(i).student.getId();
                    String name = tableData.rowOfTable.get(i).student.getName();
                    int age = tableData.rowOfTable.get(i).student.getAge();
                    int phone = tableData.rowOfTable.get(i).student.getPhone();
//                    System.out.println(tableData.rowOfTable.get(i).student);
                    if (id != 0 || !name.isEmpty() || age != 0 || phone != 0) {
                        Student student = new Student(name, id, age, phone);
                        DatabaseClass databaseClass = new DatabaseClass(student);
                        databaseClass.insertData();
                    }
                }
                System.out.println("*************");
                System.out.println("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
