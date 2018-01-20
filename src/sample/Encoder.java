package sample;

public class Encoder {

    private int key;

    public String Encode (String message) {
        String encodeMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char symbol = message.charAt(i);
            if (symbol >= 'A' & symbol <= 'Z') {
                int value = ((int)symbol + key);
                if (value > 'Z')
                    value = 'A' - 1 + value % 'Z';
                encodeMessage += (char) value;
            }
            else if (symbol >= 'a' & symbol <= 'z') {
                int value = ((int)symbol + key);
                if (value > 'z')
                    value = 'a' - 1 + value % 'z';
                encodeMessage += (char) value;
            }
            else
                encodeMessage += symbol;
        }
        return encodeMessage;
    }

    public String Decode (String message) {
        String decodeMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char symbol = message.charAt(i);
            if (symbol >= 'A' & symbol <= 'Z') {
                int value = ((int)symbol - key);
                if (value < 'A')
                    value = 'Z' + 1 + (value - 'A');
                decodeMessage += (char) value;
            }
            else if (symbol >= 'a' & symbol <= 'z') {
                int value = ((int)symbol - key);
                if (value < 'a')
                    value = 'z' + 1 + (value - 'a');
                decodeMessage += (char) value;
            }
            else
                decodeMessage += symbol;
        }
        return decodeMessage;
    }

    public void setKey (String Key) {
        try {
            this.key = Math.abs(Integer.parseInt(Key)) % ('z' - 'a');
        } catch (NumberFormatException ex) {
            this.key = 0;
        }
    }
}
