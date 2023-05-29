//package taskxml;
// 
//import java.io.IOException;
//
///**
// *
// * @author gamal
// */
//public class SimpleParser {
//
//    private Token currentToken = null;
//    public SimpleLexer lexer;
//
//    public SimpleParser(SimpleLexer lexer) {
//        this.lexer = lexer;
//    }
//
// public void eat(TokenType type) throws Exception {
//
//        if (currentToken.type == type) {
//            try {
//                currentToken = lexer.getNextToken();
//            } catch (IOException e) {
//                Error("Unexpected Token " + type);
//            }
//        } else {
//            Error("Unexpected Token " + type);
//        }
//    }
//
//    private void Error(String msg) throws Exception {
//        throw new Exception(msg);
//    }
//
//    public Token getNextToken() throws Exception {
//        try {
//            if (currentToken == null) {
//                currentToken = lexer.getNextToken();
//            }
//            return currentToken;
//        } catch (IOException e) {
//            Error(e.getMessage());
//            return null;
//        }
//    }//    S ::= E$
//    public TableData Expr() throws Exception {
//        Token nt = getNextToken();
//        TableData tableData =new TableData();
//        switch (nt.type) {
//            case OT:
//                tableData=E();
//                eat(TokenType.EOF);
//                break;
//            default:
//                Error("unexpected token " + nt);
//
//        }
//        return tableData;
//    }
//    public TableData E() throws Exception {
//        Token nt = getNextToken();
//        String idCT="";
////        print(nt);
//        TableData tableData =new TableData();
//        switch (nt.type) {
//            case OT:
//                tableData=OT();
//                idCT=E_prime();
//                break;
//            default:
//                Error("unexpected token " + nt);
//        }
//        return tableData;
//    }
////    E' ::= TEXT CT
//    // return id for CT
//    public String E_prime() throws Exception {
//        Token nt = getNextToken();
////        System.out.println("--- "+ nt);
//        String idCT="";
//        switch (nt.type) {
//            case OT:
//                E();
//                idCT=CT();
////                System.out.println("idCT "+idCT);
//                break;
//            case TEXT:
//                eat(TokenType.TEXT);
//                idCT=CT();
////                System.out.println("idCT "+idCT);
//                break;
//            case EOF:
//                break;
//            default:
//                Error("unexpected token f" + nt);
//        }
//        return idCT;
//    }
//// OT ::= < ID OT'
//    //return TableData detils
//    public TableData OT() throws Exception {
//        Token nt = getNextToken();
////        Student student=new Student();
//        TableData tableData=new TableData();
//        RowOfTable rowOfTable=new RowOfTable();
//        switch (nt.type) {
//            case OT:
//                eat(TokenType.OT);
////                eat(TokenType.ID);
////                 System.out.println("--- "+ nt.text);
////                tableData.setRowOfTable(OTGetValueID());
////                tableData.rowOfTable.setStudent(OT_prime());
//                tableData.rowOfTable.add(OTGetValueID());
//                rowOfTable.student=OT_prime();
//                tableData.rowOfTable.add(rowOfTable);
//                System.out.println(tableData);
//                break;
//            default:
//                Error("unexpected token " + nt);
//        }
//        return tableData;
//    }
//    // return the name of raw and Student details
//    public RowOfTable OTGetValueID() throws Exception {
//        Token nt = getNextToken();
////        Student student=new Student();
//        RowOfTable rowOfTable=new RowOfTable();
//        switch (nt.type) {
//            case ID:
//                rowOfTable.setRowName(nt.text);
//                eat(TokenType.ID);
////                 System.out.println("--- "+ nt.text);
//                rowOfTable.setStudent(OT_prime());
//                System.out.println(rowOfTable);
//                break;
//            default:
//                Error("unexpected token " + nt);
//        }
//        return rowOfTable;
//    }
////    OT' ::= ATT >
////    OT' ::= >
//    //return Student details
//    public Student OT_prime() throws Exception {
//        Token nt = getNextToken();
//        Student student=new Student();
//        switch (nt.type) {
//            case CT:
//                eat(TokenType.CT);
//                return null;
//            case ATT:
////                System.out.println("-- "+ nt);
//                student.setId(Integer.parseInt(ATT(TokenType.NUM)));
//                student.setName(ATT(TokenType.TEXT));
//                student.setAge(Integer.parseInt(ATT(TokenType.NUM)));
//                student.setPhone(Integer.parseInt(ATT(TokenType.NUM)));
//                eat(TokenType.CT);
//                return student;
//            default:
//                Error("unexpected token " + nt);
//        }
//        return student;
//    }
////    CT ::= < / ID >
//// return id for CT Tag
//    public String CT() throws Exception {
//        Token nt = getNextToken();
//        String idCT="";
//        switch (nt.type) {
//            case OT:
//                eat(TokenType.OT);
////                eat(TokenType.ID);
//                idCT=CTGetvalueID();
//                CT_prime();
//                break;
//            case EOF:
//                break;
//            default:
//                Error("unexpected token " + nt);
//        }
//        return idCT;
//    }
//    // return id for CT Tag
//    public String CTGetvalueID() throws Exception {
//        Token nt = getNextToken();
//        switch (nt.type) {
//            case ID:
//                eat(TokenType.ID);
//                break;
//            default:
//                Error("unexpected token " + nt);
//        }
//        return  nt.text;
//    }
//    // return Ct tag
//    public void CT_prime() throws Exception {
//        Token nt = getNextToken();
//        switch (nt.type) {
//            case CT:
//                eat(TokenType.CT);                
//                break;
//            default:
//                Error("unexpected token " + nt);
//        }
//    }
////    ATT ::= id = ' NUM '
//    // return value of ATT Details
//    public String ATT(TokenType tokenType) throws Exception {
//        Token nt = getNextToken();
////        System.out.println("this "+nt.text);
//        String message="";
//        switch (nt.type) {
//            case ATT:
//                eat(TokenType.ATT);
//                eat(TokenType.QUAL);
//                eat(TokenType.QUATION);
////                System.out.println("this "+nt.text);
////                eat(tokenType);
////                eat(TokenType.QUATION);
//                message=getValue(tokenType);
//                break;
//            default:
//                Error("unexpected token " + nt);
//        }
//        return message;
//    }
//    // return value of ATT Num or Text 
//    public String getValue(TokenType tokenType) throws Exception {
//        Token nt = getNextToken();
////        System.out.println("this "+nt.text);
//        switch (nt.type) {
//            case NUM:
//                eat(tokenType);
//                eat(TokenType.QUATION);
//                break;
//            case TEXT:
//                eat(tokenType);
//                eat(TokenType.QUATION);
//                break;
//            default:
//                Error("unexpected token " + nt);
//        }
//        return nt.text;
//    }
//
//}
//
////E ::= OT E'
////E' ::= E CT
////E' ::= TEXT CT
////OT ::= < ID OT'
////OT' ::= ATT >
////OT' ::= >
////CT ::= < ID CT'
////CT' ::= >
////ATT ::= ID = ' TEXT '