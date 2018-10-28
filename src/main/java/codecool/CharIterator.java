import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CharIterator {

    public FileContent fileContent2;
    public FileContent fileContent = new FileContent(fileContent2.pathToFile);
    public int currentIndex = 0;

    Iterator<String> itr_string = fileContent.charIterator();
    public List<String> ListLetters = StreamSupport.stream(Spliterators.spliteratorUnknownSize(itr_string, Spliterator.ORDERED), false).collect(Collectors.<String> toList());
    public String[] arrayLetters = ListLetters.toArray(new String[ListLetters.size()]);

    public int currentSize = arrayLetters.length;



    public CharIterator(FileContent fileContent){
        this.fileContent = new FileContent(fileContent.pathToFile);
    }

    public boolean hasNext(){
        return currentIndex < currentSize && arrayLetters[currentIndex] != null;
    }

    public String next(){
        return arrayLetters[currentIndex++];
    }
}
