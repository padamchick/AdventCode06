import java.util.*;
import java.util.stream.Collectors;

public class SignalDecoder {
    private String decodedSignal;
    private final String filename;
    private List<String> inputList;

    public SignalDecoder(String filename) {
        this.filename = filename;
        inputList=InputFileReader.readFileAsLines(filename);
    }

    public List<Map<String,Long>> countLettersInCodes(int passwordLength) {
        List<Map<String,Long>> lettersCounter = new ArrayList<>();
        StringBuilder[] sb = new StringBuilder[passwordLength];
        //initialize all builders
        for(int i=0; i<passwordLength;i++) {
            sb[i] = new StringBuilder();
        }
        //create Strings containing all letters on particular positions
        for(String line : inputList) {
            for(int i=0; i<line.length(); i++) {
                sb[i].append(line.charAt(i));
            }
        }
        //create maps with key=letters and value=countedLetters
        for(int i=0; i<passwordLength; i++) {
            Map<String, Long> map = Arrays.stream(sb[i].toString().split("")).collect(Collectors.groupingBy(c->c,Collectors.counting()));
            lettersCounter.add(map);
        }
        return lettersCounter;
    }

    public void decodeSignal() {
        int passwordLength = inputList.get(0).length();
        List<Map<String, Long>> letterList = countLettersInCodes(passwordLength);
        decodedSignal = findCorrectSignal(letterList, passwordLength);
    }

    public String findCorrectSignal(List<Map<String, Long>> letterList, int passwordLength) {
        StringBuilder codeBuilder = new StringBuilder(passwordLength);
        for(Map<String,Long> map : letterList) {
            String mostFreqLetter = findMax(map);
            codeBuilder.append(mostFreqLetter);
        }
        return codeBuilder.toString();
    }

    public String findMax(Map<String,Long> map) {
        return map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }

    public String getDecodedSignal() {
        return decodedSignal;
    }
}