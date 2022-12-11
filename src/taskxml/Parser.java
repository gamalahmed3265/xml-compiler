package taskxml;
 
/**
 *
 * @author gamal
 */
public class Parser {

    private Token currentToken = null;
    public Lexer lexer;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    public void eat(TokenType type) throws Exception {
        try {
            if (currentToken.type == type) {
                currentToken = lexer.getNextToken();
            }
        } catch (Exception e) {
            Error("unexpected token " + type);
        }
    }

    public void Error(String msg) throws Exception {
        throw new Exception(msg);
//        System.out.println(msg);
//        System.exit(0);
    }

    public Token getNextToken() throws Exception {

        if (currentToken == null) {
            try {
                currentToken = lexer.getNextToken();
            } catch (Exception e) {
                Error(e.getMessage());
                return null;
            }
        }
        return currentToken;

    }
//    S ::= E$
    public void Expr() throws Exception {
        Token nt = getNextToken();
        switch (nt.type) {
            case OT:
                S();
                eat(TokenType.EOF);
                break;
            default:
                Error("unexpected token " + nt);

        }
    }

    //S ::= E
    public void S() throws Exception {
        Token nt = getNextToken();
//        print(nt);
        switch (nt.type) {
            case OT:
               E();
                break;
            default:
                Error("unexpected token " + nt);
        }
    }
    public void E() throws Exception {
        Token nt = getNextToken();
//        print(nt);
        switch (nt.type) {
            case OT:
                OT();
                E_prime();
                eat(TokenType.EOF);
                break;
            default:
                Error("unexpected token " + nt);
        }
    }
//    E' ::= TEXT CT

    public void E_prime() throws Exception {
        Token nt = getNextToken();
//        print(nt);
        switch (nt.type) {
            case OT:
                E();
                CT();
                break;
            case TEXT:
                eat(TokenType.TEXT);
                CT();
                break;
            default:
                Error("unexpected token f" + nt);
        }
    }
// OT ::= < ID OT'

    public void OT() throws Exception {
        Token nt = getNextToken();

        switch (nt.type) {
            case OT:
                eat(TokenType.OT);
                eat(TokenType.ID);
                OT_prime();
                break;
            default:
                Error("unexpected token " + nt);
        }
    }
//    OT' ::= ATT >
//    OT' ::= >

    public void OT_prime() throws Exception {
        Token nt = getNextToken();
        switch (nt.type) {
            case CT:
                eat(TokenType.CT);
                break;
            case ID:
                ATT();
                eat(TokenType.CT);
                break;
            default:
                Error("unexpected token " + nt);
        }
    }
//    CT ::= < / ID >

    public void CT() throws Exception {
        Token nt = getNextToken();
        switch (nt.type) {
            case OT:
                eat(TokenType.OT);
                eat(TokenType.SLASH);
                eat(TokenType.ID);
                eat(TokenType.CT);
                break;
            default:
                Error("unexpected token " + nt);
        }
    }
//    ATT ::= id = ' TEXT '

    public void ATT() throws Exception {
        Token nt = getNextToken();
        switch (nt.type) {
            case ID:
                eat(TokenType.ID);
                eat(TokenType.QUAL);
                eat(TokenType.QUATION);
                eat(TokenType.TEXT);
                eat(TokenType.QUATION);
                break;
            default:
                Error("unexpected token " + nt);
        }
    }
}
