package homework3.transliterator;

import java.util.HashMap;
import java.util.Map;

public class TransliteratorImpl implements Transliterator {
    private final Character[] ruChars = new Character[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};
    private final String[] newChars = new String[]{"A", "B", "V", "G", "D", "E", "E", "ZH", "Z", "I", "I", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "F", "KH", "TS", "CH", "SH", "SHCH", "IE", "Y", "", "E", "IU", "IA"};
    private final Map<Character, String> symbolMap = new HashMap<>();

    public TransliteratorImpl() {
        for (int i = 0; i < ruChars.length; i++) {
            this.symbolMap.put(ruChars[i], newChars[i]);
        }
    }

    @Override
    public String transliterate(String source) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (symbolMap.containsKey(source.charAt(i))) {
                result.append(symbolMap.get(source.charAt(i)));
            } else {
                result.append(source.charAt(i));
            }
        }
        return result.toString();
    }
}
