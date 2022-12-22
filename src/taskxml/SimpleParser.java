package taskxml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gamal
 */
public class SimpleParser {

    private Token currentToken = null;
    public SimpleLexer lexer;

    public SimpleParser(SimpleLexer lexer) {
        this.lexer = lexer;
    }

    public void eat(TokenType type) throws Exception {

        if (currentToken.type == type) {
            try {
                currentToken = lexer.getNextToken();
            } catch (IOException e) {
                Error("Unexpected Token " + type);
            }
        } else {
            Error("Unexpected Token " + type);
        }
    }

    private void Error(String msg) throws Exception {
        throw new Exception(msg);
    }

    public Token getNextToken() throws Exception {
        try {
            if (currentToken == null) {
                currentToken = lexer.getNextToken();
            }
            return currentToken;
        } catch (IOException e) {
            Error(e.getMessage());
            return null;
        }
    }
    public TableData Expr() throws Exception {
        Token nt = getNextToken();
        TableData tableData = new TableData();
        switch (nt.type) {
            case OT:
                tableData.rowOfTable = E();
                eat(TokenType.EOF);
                break;
            default:
                Error("unexpected token " + nt);

        }
        return tableData;
    }

    public List<RowOfTable> E() throws Exception {
        Token nt = getNextToken();
        TableData tableData = new TableData();
        RowOfTable rowOfTable = new RowOfTable();
        String tableName="";
        switch (nt.type) {
            case OT:
                    rowOfTable=OT();
                    tableData.rowOfTable=E_prime();
                    tableData.rowOfTable.add(rowOfTable);
                break;
            default:
                Error("unexpected token " + nt);
        }
        return tableData.rowOfTable;
    }
    // return id for CT and recursion itself
    public List<RowOfTable> E_prime() throws Exception {
        Token nt = getNextToken();
        List<RowOfTable> r=new ArrayList<RowOfTable>();
        String idCT = "";
        switch (nt.type) {
            case OT:
                r=E();
                idCT=CT();
                break;
            case TEXT:
                eat(TokenType.TEXT);
                idCT=CT();
                break;
            case EOF:
                break;
            default:
                Error("unexpected token f" + nt);
        }
        return r;
    }
    //return TableData detils
    public RowOfTable OT() throws Exception {
        Token nt = getNextToken();
        RowOfTable rowOfTable = new RowOfTable();
        switch (nt.type) {
            case OT:
                eat(TokenType.OT);
                rowOfTable=OTGetValueID();
                break;
            default:
                Error("unexpected token " + nt);
        }
        return rowOfTable;
    }

    // return the name of raw and Student details
    public RowOfTable OTGetValueID() throws Exception {
        Token nt = getNextToken();
        RowOfTable rowOfTable = new RowOfTable();
        switch (nt.type) {
            case ID:
                rowOfTable.setRowName(nt.text);
                eat(TokenType.ID);
                rowOfTable.setStudent(OT_prime());
                break;
            default:
                Error("unexpected token " + nt);
        }
        return rowOfTable;
    }
    //return Student details
    public Student OT_prime() throws Exception {
        Token nt = getNextToken();
        Student student = new Student();
        switch (nt.type) {
            case CT:
                eat(TokenType.CT);
                break;
            case ATT:
                student.setId(Integer.parseInt(ATT(TokenType.NUM)));
                student.setName(ATT(TokenType.TEXT));
                student.setAge(Integer.parseInt(ATT(TokenType.NUM)));
                student.setPhone(Integer.parseInt(ATT(TokenType.NUM)));
                eat(TokenType.CT);
                return student;
            default:
                Error("unexpected token " + nt);
        }
        return student;
    }
// return id for CT Tag
    public String CT() throws Exception {
        Token nt = getNextToken();
        String idCT = "";
        switch (nt.type) {
            case OT:
                eat(TokenType.OT);
                idCT = CTGetvalueID();
                CT_prime();
                break;
            case EOF:
                break;
            default:
                Error("unexpected token " + nt);
        }
        return idCT;
    }

    // return id for CT Tag
    public String CTGetvalueID() throws Exception {
        Token nt = getNextToken();
        switch (nt.type) {
            case ID:
                eat(TokenType.ID);
                break;
            default:
                Error("unexpected token " + nt);
        }
        return nt.text;
    }

    // return Ct tag
    public void CT_prime() throws Exception {
        Token nt = getNextToken();
        switch (nt.type) {
            case CT:
                eat(TokenType.CT);
                break;
            default:
                Error("unexpected token " + nt);
        }
    }
    // return value of ATT Details

    public String ATT(TokenType tokenType) throws Exception {
        Token nt = getNextToken();
        String message = "";
        switch (nt.type) {
            case ATT:
                eat(TokenType.ATT);
                eat(TokenType.QUAL);
                eat(TokenType.QUATION);
                message = getValue(tokenType);
                break;
            default:
                Error("unexpected token " + nt);
        }
        return message;
    }

    // return value of ATT Num or Text 
    public String getValue(TokenType tokenType) throws Exception {
        Token nt = getNextToken();
        switch (nt.type) {
            case NUM:
                eat(tokenType);
                eat(TokenType.QUATION);
                break;
            case TEXT:
                eat(tokenType);
                eat(TokenType.QUATION);
                break;
            default:
                Error("unexpected token " + nt);
        }
        return nt.text;
    }
}