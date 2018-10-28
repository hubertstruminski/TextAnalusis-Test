import java.util.*;

public class Application {

    public static void main(String[] args){
        View view = new View();
        

        if((args[0].equals("test.txt") || args[0].equals("test2.txt") || args[0].equals("output_test_test2.txt") || args[0].equals("test_dickens_great.txt") || args[0].equals("test_malville_moby.txt"))
                && (args[1].equals("test.txt") || args[1].equals("test2.txt") || args[1].equals("output_test_test2.txt") || args[1].equals("test_dickens_great.txt") || args[1].equals("test_malville_moby.txt"))){

            long startTime = System.nanoTime();

            System.out.println("====" + args[0] + "====");
            //------------------------------------------------first file
            FileContent fileContent0 = new FileContent("/home/hubert/Pulpit/checkpoint-3-text-analysis-hubertstruminski/" + args[0]);
            StatisticalAnalysis ratioAllLettersObject0 = new StatisticalAnalysis(fileContent0.charIterator());


            view.printSize(args[0]);
            view.printDictionarySize(args[0]);
            view.print(1, args[0]);

            System.out.println();
            view.print("love", args[0]);
            view.print("hate", args[0]);
            view.print("music", args[0]);

            view.printVowels(args[0]);
            view.printCountRatio(args[0]);
            HashMap<String, Double> hashMapRatio = ratioAllLettersObject0.ratioAllLetters();
            view.printRatioAllLetters(hashMapRatio, args[0]);

            long duration = System.nanoTime() - startTime;
            System.out.println();
            System.out.println("Time of running app for " + args[0] + ": " + duration + " in nanoseconds");
            

            //---------------------------------------------------------
            System.out.println("------------------------------------------");
            System.out.println("====" + args[1] + "====");
            //-------------------------------------------------second file
            long startTime2 = System.nanoTime();

            FileContent fileContent1 = new FileContent("/home/hubert/Pulpit/checkpoint-3-text-analysis-hubertstruminski/" + args[1]);
            StatisticalAnalysis ratioAllLettersObject1 = new StatisticalAnalysis(fileContent1.charIterator());



            view.printSize(args[1]);
            view.printDictionarySize(args[1]);
            view.print(1, args[1]);

            System.out.println();
            view.print("love", args[1]);
            view.print("hate", args[1]);
            view.print("music", args[1]);

            view.printVowels(args[1]);
            view.printCountRatio(args[1]);
            HashMap<String, Double> hashMapRatio2 = ratioAllLettersObject1.ratioAllLetters();
            view.printRatioAllLetters(hashMapRatio2, args[1]);


            long duration2 = System.nanoTime() - startTime2;
            System.out.println();
            System.out.println("Time of running app " + args[1] + ": "  + duration2 + " in nanoseconds");
        }
    }
}
