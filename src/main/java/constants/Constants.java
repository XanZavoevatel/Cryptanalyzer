package constants;

public class Constants {
    private  static final String rus = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
    private  static final String eng = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private  static final String chars = "!@#$%^&*()_+{}\":?><\\/,.;'=-";
    private  static final String cypher = "1234567890";
    public  static String ALPHABET = rus + eng + rus.toLowerCase() + eng.toLowerCase() + chars + chars;

}
