public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (Character ch: word.toCharArray()) {
            deque.addLast(ch);
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> characterDeque = wordToDeque(word);
        return isPalindrome(characterDeque);
    }

    private boolean isPalindrome(Deque<Character> characterDeque) {
        if (characterDeque.size() < 2) {
            return true;
        }
        Character c1 = characterDeque.removeFirst();
        Character c2 = characterDeque.removeLast();
        if (c1 != c2) {
            return false;
        } else {
            return isPalindrome(characterDeque);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> characterDeque = wordToDeque(word);
        return isPalindrome(characterDeque, cc);
    }

    private boolean isPalindrome(Deque<Character> characterDeque, CharacterComparator cc) {
        if (characterDeque.size() < 2) {
            return true;
        }
        Character c1 = characterDeque.removeFirst();
        Character c2 = characterDeque.removeLast();
        if (!cc.equalChars(c1, c2)) {
            return false;
        } else {
            return isPalindrome(characterDeque, cc);
        }
    }
}
