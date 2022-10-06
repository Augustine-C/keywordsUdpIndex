import java.util.Map;
import java.util.TreeMap;

public class DataProcessor {
    Map<Integer, Integer> yearCountMap;

    public DataProcessor(){
        yearCountMap = new TreeMap<>();
    }
    public void process(String data) {
        // data = "2022(19)2021(6)2020(21)2019(31)2018(22)2017(18)2016(31)2015(5)2014(10)2013(23)2012(17)2011(21)2010(4)2009(4)2008(5)2007(1)2006(4)2005(5)2004(1)2003(4)2002(3)2001(4)2000(1)"
        String[] yearCounts = data.split("\\)");
        for (String yearCount : yearCounts) {
            if(yearCount.length() == 0){
                continue;
            }
            String[] yearCountArray = yearCount.split("\\(");
            int year = Integer.parseInt(yearCountArray[0]);
            int count = Integer.parseInt(yearCountArray[1]);
            System.out.println(year + " " + count);
            yearCountMap.put(year, count + yearCountMap.getOrDefault(year, 0));
        }
    }

    public Map<Integer, Integer> getYearCount(){
        return yearCountMap;
    }

    public Map<Integer, Double> getResult(){
        int numYear = yearCountMap.size();
        int total = 0;
        for (Integer count : yearCountMap.values()) {
            total += count;
        }
        double y1 = (total + 0.0) / numYear;
        double y2 = 100.0 / y1;
        Map<Integer, Double> result = new TreeMap<>();
        for (Integer year : yearCountMap.keySet()) {
            int count = yearCountMap.get(year);
            double udp = count * y2;
            result.put(year, udp);
        }
        return result;
    }
}
