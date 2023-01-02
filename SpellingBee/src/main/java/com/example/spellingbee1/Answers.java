package com.example.spellingbee1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Answers  {
    public static final ArrayList<String> kelimeler = new ArrayList<>(); //arraylist of all words in dictionary.
    public static ArrayList<Character> harfler = new ArrayList<>(); //arraylist of all chars
    public static ArrayList<String> cevaplar = new ArrayList<>();
    {
        Character merkez=harfler.get(6);
        System.out.println("Merkez Kelime : "+merkez);
        //System.out.println("\nLetters chosen: " + harfler + "\n");

        try {
            sozluktenAyikla();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i =0; i<kelimeler.size(); i++){
            if( kelimeler.get(i).indexOf(merkez) !=-1 ){
                cevaplar.add(kelimeler.get(i));
            }
        }
        System.out.println("*************");
        System.out.println(cevaplar.size());
        for(String kelime:cevaplar){


            System.out.println(kelime);
        }

        //System.out.println("Cevaplar : [" + cevaplar.size() + "]"); //cevapların numaraları

        if (kelimeler.size() == 0) System.out.println("No matching words found!");
        for (int i = 0; i < kelimeler.size(); i++) {
            //System.out.println((i + 1) + " : " + kelimeler.get(i));
        }
    }

    public static void sozluktenAyikla() throws IOException {
        File dictionary = new File("src\\main\\java\\com\\example\\spellingbee1\\VPSOZLUK.txt");
        BufferedReader readDictionary = new BufferedReader(new FileReader(dictionary)); //read file

        String kelime = null;

        while (true) {
            try {
                if (!((kelime = readDictionary.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (gecerliKelimeMi(kelime)) kelimeler.add(kelime);
        }
    }

    public static boolean gecerliKelimeMi(String kelime) {
        int minKelimeUzunlugu = 3;
        if (kelime.length() <= minKelimeUzunlugu) return false;
        int eslesenKelime = 0;

        for (int i = 0; i < kelime.length(); i++) {
            for (Character charLetter : harfler)
                if (charLetter == kelime.charAt(i)) eslesenKelime++;
        }
        return eslesenKelime == kelime.length();
    }

    /*public ArrayList<Character> getAllrs() {
        return harfler;
    }*/
}