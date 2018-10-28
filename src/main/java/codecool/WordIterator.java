import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class WordIterator {

    public FileContent fileContent2;
    public FileContent fileContent = new FileContent(fileContent2.pathToFile);
    public int currentIndex = 0;


    Iterator<String> itr_string = fileContent.charIterator();
    public List<String> ListWords = StreamSupport.stream(Spliterators.spliteratorUnknownSize(itr_string, Spliterator.ORDERED), false).collect(Collectors.<String> toList());
    public String[] arrayWords = ListWords.toArray(new String[ListWords.size()]);

    public int currentSize = arrayWords.length;


    public WordIterator(FileContent fileContent){
        this.fileContent = new FileContent(fileContent.pathToFile);
    }

    public boolean hasNext(){
        return currentIndex < currentSize && arrayWords[currentIndex] != null;
    }

    public String next(){
        return arrayWords[currentIndex++];
    }
}
