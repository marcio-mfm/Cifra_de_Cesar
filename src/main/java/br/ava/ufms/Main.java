package br.ava.ufms;

public class Main {
    public static void main(String[] args) {
        String texto = "Hello World";
        int deslocamento = 3;

        String criptografado = criptografar(texto, deslocamento);
        String descriptografado = descriptografar(criptografado, deslocamento);

        System.out.println("Criptografado: " + criptografado);
        System.out.println("Descriptografado: " + descriptografado);
    }

    public static String criptografar(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                result.append((char) ((character - base + shift) % 26 + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static String descriptografar(String text, int shift) {
        return criptografar(text, 26 - shift);
    }
}