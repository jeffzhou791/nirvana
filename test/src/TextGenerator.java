import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TextGenerator {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new FileReader("sample.txt"));
        TextGenerator generator = new TextGenerator(r);
        System.out.println(generator.generateRandomText(1000));
    }

    private final BufferedReader reader;
    private final Map<String, MarkovNode> markovNodeMap = new HashMap<>();

    private final Map<String, Map<String, Integer>> nextWordsMap = new HashMap<>();

    private static class MarkovNode {
        final String word;
        int[] percentiles = null;
        MarkovNode[] nextNodes = null;

        MarkovNode nextNode() {
            if (percentiles == null) {
                return null;
            }
            int i = new Random().nextInt(100);
            for (int j = 0; j < percentiles.length; j++) {
                if (i < percentiles[j]) {
                    return nextNodes[j];
                }
            }
            throw new RuntimeException("Did not return any next nodes, percentiles may be wrong");
        }

        MarkovNode(String word) {
            this.word = word;
        }

        String getWord() {
            return word;
        }

        void initialize(List<MarkovNode> nextNodes, List<Integer> occurrences) {
            // Check non-null for percentiles and nextNodes
            if (occurrences.size() != nextNodes.size()) {
                throw new RuntimeException("Wrong arguments: the size of occurrences is not the same as the size of nextNodes");
            }
            int sum = 0;
            for (int occurrence : occurrences) {
                sum += occurrence;
            }

            percentiles = new int[occurrences.size()];

            percentiles[0] = occurrences.get(0) * 100 / sum;
            for (int i = 1; i < occurrences.size(); i++) {
                percentiles[i] = percentiles[i - 1] + occurrences.get(i) * 100 / sum;
            }

            // Compensate for the precision loss
            percentiles[occurrences.size() - 1] = 100;

            this.nextNodes = nextNodes.toArray(new MarkovNode[0]);
        }
    }

    TextGenerator(BufferedReader r) throws IOException {
        reader = r;
        String line = reader.readLine();

        while (line != null) {
            processWords(getWords(line));
            line = reader.readLine();
        }
        initializeMarkovChain();
    }

    public String generateRandomText(int numberOfWords) {
        MarkovNode node = getRandomNode();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < numberOfWords; i++) {
            b.append(node.getWord());
            b.append(" ");
            node = node.nextNode();
            if (node == null) {
                node = getRandomNode();
            }
        }
        return b.toString();
    }

    private static List<String> getWords(String line) {
        return Arrays.asList(line.split("\\s"));
    }

    private void processWords(List<String> words) {
        if (words == null || words.size() < 2) {
            return;
        }
        for (int i = 0; i < words.size() - 1; i++) {
            String word = words.get(i);
            initWordRecord(word);
            addNextWordOccurrence(word, words.get(i+1));
        }
    }

    private void addNextWordOccurrence(String word, String nextWord) {
        Map<String, Integer> nextWordOccurrence = nextWordsMap.get(word);
        if (!nextWordOccurrence.containsKey(nextWord)) {
            nextWordOccurrence.put(nextWord, 1);
        } else {
            nextWordOccurrence.put(nextWord, nextWordOccurrence.get(nextWord) + 1);
        }
    }

    private void initWordRecord(String word) {
        if (!nextWordsMap.containsKey(word)) {
            nextWordsMap.put(word, new HashMap<String, Integer>());
        }
    }

    private void initializeMarkovChain() {
        for (Map.Entry<String, Map<String, Integer>> entry1 : nextWordsMap.entrySet()) {
            MarkovNode node = getMarkovNode(entry1.getKey());
            List<MarkovNode> nextNodes = new ArrayList<>();
            List<Integer> occurrences = new ArrayList<>();
            for (Map.Entry<String, Integer> entry2 : entry1.getValue().entrySet()) {
                nextNodes.add(getMarkovNode(entry2.getKey()));
                occurrences.add(entry2.getValue());
            }
            node.initialize(nextNodes, occurrences);
        }
    }

    private MarkovNode getMarkovNode(String word) {
        if (!markovNodeMap.containsKey(word)) {
            markovNodeMap.put(word, new MarkovNode(word));
        }
        return markovNodeMap.get(word);
    }

    private MarkovNode getRandomNode() {
        Random rand = new Random();
        List<String> words = new ArrayList<>(markovNodeMap.keySet());
        return markovNodeMap.get(words.get(rand.nextInt(words.size())));
    }
}
