import java.util.*;

public class StatisticalAnalysis {

    private HashSet<String> hSet;
    private HashSet<String> occurMoreHashSet;
    private Iterator<String> itr;
    private int count = 0;
    private List<String> list;
    private HashMap<String, Integer> hashMap;
    private HashMap<String, Double> hashMapRatio;
    private double first = 0.0;
    private double second = 0.0;
    private int summary = 0;
    private int value = 1;
    private int elementSize = -1;


    public StatisticalAnalysis(Iterator<String> itr){
        this.itr = itr;
        this.hSet = new HashSet<>();
        this.list = new ArrayList<>();
        this.hashMap = new HashMap<>();
        this.hashMapRatio = new HashMap<>();
        this.occurMoreHashSet = new HashSet<>();
    }

    public int CountOf(String... element){

        while(itr.hasNext()){
            for(String el: element){
                String temp = itr.next();
                if(temp.equals(el)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int dictionarySize(){

        Iterator<String> itrDict = itr;

        while(itrDict.hasNext()){
            this.hSet.add(itrDict.next());
        }

        return this.hSet.size();
    }

    public int size(){

        if(elementSize == -1){
            while(itr.hasNext()){
                this.list.add(itr.next());
            }
            elementSize = this.list.size();
        }
        return elementSize;
    }

    //most used words - pozbyć się z elementów spacji
    public HashSet<String> OccurMoreThan(int n){

        while(itr.hasNext()){
            String temp = itr.next();
            int value = 1;
            if(this.hashMap.containsKey(temp)) {
                value += hashMap.get(temp);
            }

            if(!temp.contains(" ")) {
                this.hashMap.put(temp, value);
            }
        }
        double amount = size() * 0.01 * n;
        List<String> list = new ArrayList<>();


        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue() >= amount){
                occurMoreHashSet.add(entry.getKey() + " (" + entry.getValue() + "%)");
            }
        }

        return occurMoreHashSet;

    }

    public double vowels(){

        while(itr.hasNext()){
            String temp = itr.next();
            if(temp.equalsIgnoreCase("a") || temp.equalsIgnoreCase("o") || temp.equalsIgnoreCase("i") ||
                    temp.equalsIgnoreCase("e") || temp.equalsIgnoreCase("u")){
                if(this.hashMap.containsKey(temp)) {
                    value += hashMap.get(temp);
                }
                hashMap.put(temp, value);
            }
        }
        for (String key : hashMap.keySet()) {
            summary += hashMap.get(key);
        }
        return (summary / this.elementSize) * 100;
    }

    public double countRatio(){
        while(itr.hasNext()){
            String temp = itr.next();
            if(temp.equalsIgnoreCase("a") || temp.equalsIgnoreCase("e")){
                int value = 1;
                if(this.hashMap.containsKey(temp)) {
                    value += hashMap.get(temp);
                }
                this.hashMap.put(temp, value);
            }
        }
        for (String key : hashMap.keySet()) {
            if(key.equalsIgnoreCase("a")){
                first = hashMap.get(key);
            }else if(key.equalsIgnoreCase("e")){
                second = hashMap.get(key);
            }
        }
        return first / second;
    }

    public HashMap<String, Double> ratioAllLetters(){
        while(itr.hasNext()){
            String temp = itr.next().toLowerCase();
            value = 1;
            if(this.hashMap.containsKey(temp)) {
                value = this.hashMap.get(temp) + 1;
            }
            this.hashMap.put(temp, value);
        }

        for(String key: hashMap.keySet()){
            double ratio = (double)hashMap.get(key) / 1034;
            hashMapRatio.put(key, ratio);
        }

        return hashMapRatio;

    }
}
