package ua.univer.lesson06;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.*;

public class Program {
    public static void main(String[] args) throws IOException {
//        List<Integer> list = Arrays.asList(1,2,3,45,2,6,4,2,32,3,4,3,2,34,2,32);
//        List<Integer> l1 = getUniqIntegers(list);
//        System.out.println(l1);
//
//        String str = "mama mila ramu ramu mila mama mila ruma";
//        Set<String> setName = getUniqStrings(str);
//        System.out.println(setName);
        Map<String,  Map<String, Integer>> mapFreqAll = new HashMap<>();
        String url = "https://www.stihi-rus.ru/World/Shekspir/1.htm";
        for (int i = 1; i < 10; i++) {
            Map<String, Integer> mapFregUrl   = getMapFreqFromURL("https://www.stihi-rus.ru/World/Shekspir/"+i+".htm");
            for (var key: mapFregUrl.keySet())
                 {
                     if (!mapFreqAll.containsKey(key))
                         mapFreqAll.put(key, new HashMap<>());
                     mapFreqAll.get(key).put("https://www.stihi-rus.ru/World/Shekspir/"+i+".htm", mapFregUrl.get(key));
                 }
        }
        System.out.println(mapFreqAll);
    }



    private static Map<String, Integer> getMapFreqFromURL(String url) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream(), Charset.forName("WINDOWS-1251")));

        while (br.ready()){
            sb.append(br.readLine());
        }
        Map<String, Integer> mapFreq = getMapFreq(sb.toString());
        return mapFreq;
    }

    private static Map<String, Integer> getMapFreqFromTXT(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while (br.ready()){
            sb.append(br.readLine());
        }
        Map<String, Integer> mapFreq = getMapFreq(sb.toString());
        return mapFreq;
    }

    private static Set<String> getUniqStrings(String str) {
        Set<String> setName = new HashSet<>();
        setName.addAll(List.of(str.split(" ")));
        return setName;
    }

    private static List<Integer> getUniqIntegers(List<Integer> list) {
        Set set = new HashSet<>(list);
        System.out.println(Arrays.toString(set.toArray()));
        List<Integer> l1 =  new ArrayList<>(set);
        return l1;
    }

    private static Map<String, Integer> getMapFreq(String str) {
        Map<String, Integer> mapFreq = new HashMap<>();
        String [] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!mapFreq.containsKey(words[i])){
                mapFreq.put(words[i], 1);
            }
            else mapFreq.put(words[i], mapFreq.get(words[i])+1);
        }
        return mapFreq;
    }


}
