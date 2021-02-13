package iterator;

import java.util.Iterator;

public class Main {
    public static void main(final String[] args) {
        final Word.Root root = new Word.Root("дач");
        final Word.Prefix prefix = new Word.Prefix("за");
        final Word.Suffix suffix = new Word.Suffix("к");
        final Word.Ending ending = new Word.Ending("а");

        final Word word = new Word(root, prefix, suffix, ending);

        final Iterator wordIterator = word.iterator();

        while (wordIterator.hasNext()){
            final Word.WordPart part = (Word.WordPart) wordIterator.next();
            System.out.println(part.getClass() + ": " + part.getWordPart());
        }

        final Iterator wordIterator1 = word.iterator();

        while (wordIterator1.hasNext()){
            Word.WordPart part = (Word.WordPart) wordIterator1.next();
            System.out.println(part.getWordPart()+"!");
        }
    }
}
