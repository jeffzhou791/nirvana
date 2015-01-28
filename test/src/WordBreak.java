import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    private static final String[] dictWords = {"dog", "cat", "cats", "sand", "and"};
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictWords));
        WordBreak breaker = new WordBreak();
        System.out.println(breaker.wordBreak("catsanddog", dict));
    }
    public List<String> wordBreak(String s, Set<String> dict) {
        CandidateSentence sentence = new CandidateSentence();
        sentence.dict = dict;
        List<CandidateSentence> sentences = new ArrayList<>();
        sentences.add(sentence);
        for (char c : s.toCharArray()) {
            List<CandidateSentence> moreCandidates = new ArrayList<>();
            for (CandidateSentence candidate : sentences) {
                CandidateSentence moreCandidate = candidate.append(c);
                if (moreCandidate != null) {
                    moreCandidates.add(moreCandidate);
                }
            }
            sentences.addAll(moreCandidates);
        }
        return compose(sentences);
    }

    private static List<String> compose(List<CandidateSentence> sentences) {
        List<String> results = new ArrayList<>();
        for (CandidateSentence sentence : sentences) {
            if (sentence.incoming.equals("")) {
                StringBuffer b = new StringBuffer();
                for (String word : sentence.words) {
                    b.append(word);
                    b.append(" ");
                }
                b.deleteCharAt(b.length() - 1);
                results.add(b.toString());
            }
        }
        return results;
    }

    static class CandidateSentence {
        List<String> words = new ArrayList<>();
        String incoming = "";
        Set<String> dict = new HashSet<>();
        CandidateSentence() {}
        CandidateSentence(List<String> words, String incoming, Set<String> dict) {
            this.words = words;
            this.incoming = incoming;
            this.dict = dict;
        }
        CandidateSentence append(char c) {
            incoming += c;
            if (dict.contains(incoming)) {
                List<String> words = new ArrayList<>(this.words);
                words.add(incoming);
                CandidateSentence sentence = new CandidateSentence(words, "", dict);
                return sentence;
            }
            return null;
        }
    }
}
