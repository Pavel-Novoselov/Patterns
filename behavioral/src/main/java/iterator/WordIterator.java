package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class WordIterator implements Iterator<Word.WordPart> {
    private Word word;
    private int wordPartsCount;

    public WordIterator(final Word word) {
        this.word = word;
        this.wordPartsCount = word.getPartCount();
    }

    @Override
    public boolean hasNext() {
        if (wordPartsCount == 4) {
            return word.hasPrefix() || word.hasRoot() || word.hasSuffix() || word.hasEnding();
        } else if (wordPartsCount == 3) {
            return word.hasPrefix() || word.hasRoot() || word.hasSuffix();
        } else if (wordPartsCount == 2) {
            return word.hasPrefix() || word.hasRoot();
        } else if (wordPartsCount == 1) {
            return word.hasRoot();
        }
        return false;
    }

    @Override
    public Word.WordPart next() {
        if (wordPartsCount <= 0) {
            throw new NoSuchElementException("No more elements in this word!");
        }

        try{
            if (wordPartsCount == 4){
                return word.getEnding();
            }
            if (wordPartsCount == 3) {
                return word.getSuffix();
            }
            if (wordPartsCount == 2) {
                return word.getPrefix();
            }
            return word.getRoot();
        } finally {
            wordPartsCount--;
        }
    }

    @Override
    public void remove() {

    }
}
