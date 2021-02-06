package behavioral;

import iterator.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorTest {
    private final Word word = new Word(new Word.Root("дач"), new Word.Prefix("за"), new Word.Suffix("к"), new Word.Ending("а"));
    final Iterator wordIterator = word.iterator();

    @Test
    public void iterTest(){
        final Map<String, Word.WordPart> map = new HashMap<>();
        while (wordIterator.hasNext()){
            final Word.WordPart part = (Word.WordPart) wordIterator.next();
            map.put(part.getClass().getName(), part);
        }
        Assertions.assertEquals("дач", map.get("iterator.Word$Root").getWordPart());
    }
}
