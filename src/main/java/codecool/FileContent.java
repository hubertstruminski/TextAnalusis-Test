import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class FileContent implements IterableText{

    public String pathToFile;
    public ArrayList<String> splittedLetters;
    public ArrayList<String> splittedWords;

    public FileContent(String pathToFile){
        this.pathToFile = pathToFile;
        this.splittedLetters = new ArrayList<String>();
        this.splittedWords = new ArrayList<String>();
    }

    public Iterator<String> charIterator(){
        try (BufferedReader br = new BufferedReader(new FileReader(this.pathToFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splittedText = line.split("");


                for(String letter: splittedText){
                    if(!letter.equals(" ")){
                        splittedLetters.add(letter);
                    }
                }

            }
            Iterator<String> itr = splittedLetters.iterator();

            while(itr.hasNext()){
                return itr;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Iterator<String> wordIterator(){
        try (BufferedReader br = new BufferedReader(new FileReader(this.pathToFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splittedText = line.split(" ");

                for(String word: splittedText){
                    if(!word.equals(" ")){
                        splittedWords.add(word);
                    }
                }
            }
            Iterator<String> itr = splittedWords.iterator();

            while(itr.hasNext()){
                return itr;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getFilename(String[] args){
        return args[2];
    }
}
