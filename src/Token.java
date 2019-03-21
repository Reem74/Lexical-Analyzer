public class Token {
    String regex;
    String  ID;

    Token(String regex, String ID)  {
        this.regex = regex;
        this.ID = ID;
    }
    public void setRegex(String regex) {
        this.regex = regex;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getRegex() {
        return this.regex;
    }
    public String getID() {
        return this.ID;
    }

}
