import java.util.HashSet;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.text.DecimalFormat;

public class View {

    //occurMoreThan - most used words
    public void print(int number, String fileName){
        FileContent fileContent = new FileContent("/home/hubert/Pulpit/checkpoint-3-text-analysis-hubertstruminski/" + fileName);
        StatisticalAnalysis occurMoreObject = new StatisticalAnalysis(fileContent.wordIterator());

        HashSet<String> hSet = occurMoreObject.OccurMoreThan(number);

        for(String element: hSet){
            System.out.print("[ ");
            System.out.print(element);
            System.out.print(" ] ");
        }
    }

    public void print(String element, String fileName){
        FileContent fileContent = new FileContent("/home/hubert/Pulpit/checkpoint-3-text-analysis-hubertstruminski/" + fileName);
        StatisticalAnalysis countOfObject = new StatisticalAnalysis(fileContent.wordIterator());

        System.out.println(element + ": " + countOfObject.CountOf(element));
    }

    public void printVowels(String fileName){
        FileContent fileContent = new FileContent("/home/hubert/Pulpit/checkpoint-3-text-analysis-hubertstruminski/" + fileName);
        StatisticalAnalysis vowelsObject = new StatisticalAnalysis(fileContent.charIterator());

        System.out.println("Vowels %: " + vowelsObject.vowels());
    }

    public void printCountRatio(String fileName){
        FileContent fileContent = new FileContent("/home/hubert/Pulpit/checkpoint-3-text-analysis-hubertstruminski/" + fileName);
        StatisticalAnalysis countRatioObject = new StatisticalAnalysis(fileContent.charIterator());

        System.out.println("Ratio a:e : " + countRatioObject.countRatio());
    }


    //-------------------------------------------------------------------------------------------------------------------

    public void printSize(String fileName){
        FileContent fileContent = new FileContent("/home/hubert/Pulpit/checkpoint-3-text-analysis-hubertstruminski/" + fileName);
        StatisticalAnalysis SizeChar = new StatisticalAnalysis(fileContent.charIterator());
        StatisticalAnalysis SizeWord = new StatisticalAnalysis(fileContent.wordIterator());

        System.out.println("Char count: " + SizeChar.size());
        System.out.println("Word count: " + SizeWord.size());      
    }

    public void printDictionarySize(String fileName){
        FileContent fileContent = new FileContent("/home/hubert/Pulpit/checkpoint-3-text-analysis-hubertstruminski/" + fileName);
        StatisticalAnalysis SizeChar = new StatisticalAnalysis(fileContent.charIterator());
        StatisticalAnalysis SizeWord = new StatisticalAnalysis(fileContent.wordIterator());

        System.out.println("Dictionary size for char: " + SizeChar.dictionarySize());
        System.out.println("Dictionary size for word: " + SizeWord.dictionarySize());
    }

    public void printRatioAllLetters(HashMap<String, Double> hashMapRatio, String fileName){
        FileContent fileContent = new FileContent("/home/hubert/Pulpit/checkpoint-3-text-analysis-hubertstruminski/" + fileName);
        StatisticalAnalysis ratioAllLettersObject = new StatisticalAnalysis(fileContent.charIterator());

        hashMapRatio = ratioAllLettersObject.ratioAllLetters();

        // double d = 2.34568;
        DecimalFormat f = new DecimalFormat("##.00");
        // System.out.println(f.format(d));
        for (Map.Entry<String, Double> entry : hashMapRatio.entrySet()) {
        
            System.out.print("[ " + entry.getKey() + " -> " + f.format(entry.getValue() * 100) + "% ], ");
        }
    }
}
