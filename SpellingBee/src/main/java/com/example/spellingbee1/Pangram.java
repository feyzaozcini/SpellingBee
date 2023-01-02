package com.example.spellingbee1;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Pangram {
    BufferedReader okunan;
    ArrayList<String> yediHarfliler=new ArrayList<>();
    ArrayList<String> farkli=new ArrayList<>();
    {
        try {
            okunan = new BufferedReader(new FileReader("src\\main\\java\\com\\example\\spellingbee1\\VPSOZLUK.txt"));
            String line = null;
            String specialCharacter = " ";
            ArrayList<String> kelimeler=new ArrayList<>();

            while ((line = okunan.readLine()) != null) {
                kelimeler.add(line);
            }

            for(String kelime:kelimeler){
                int sayac=0;
                for(int i=0;i<kelime.length();i++){
                    for(int j=i+1;j<kelime.length();j++){
                        if(kelime.charAt(i) == kelime.charAt(j)){
                            sayac++;
                        }
                    }
                }
                //System.out.println(kelime);
                //System.out.println("TEKRAR EDEN HARF SAYISI "+sayac+" ");
                int sade=kelime.length()-(sayac);
                if(sade==7){
                    yediHarfliler.add(kelime);
                }
                // System.out.println("SADE HALİ "+sade+" ");
            }
            // System.out.println("7 farklı harf içeren kelimeler");

            char[] harfler=new char[7];
            for (String word:yediHarfliler) {
                String result = new String("");

                for (int i = 0; i < word.length(); i++) {
                    if (!result.contains("" + word.charAt(i))) {
                        result += "" + word.charAt(i);
                    }
                }
                farkli.add(result);
                //System.out.println(result);
                // for(String x:farkli)
                //System.out.println(x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}