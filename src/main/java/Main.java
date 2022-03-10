public class Main {
    public static void main(String[] args) {
        System.out.println("Hi!");
        String rus = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
        String eng = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String chars = "!@#$%^&*()_+{}\":?><\\/,.;'=-";
        String cypher = "1234567890";
        String alphabet = rus + eng + rus.toLowerCase() + eng.toLowerCase() + chars + chars;

    }
}
