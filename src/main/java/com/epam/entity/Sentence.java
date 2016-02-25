package com.epam.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Munar on 25.02.2016.
 */
public class Sentence {
    private List<Word> value = new ArrayList<Word>();
    /**
     таблица расположения символов
     | n | symbol |

     n - номер слова, после которого он стоит
     symbol - сам символ
     */
    private List<Symbol> nonletters;

    /*public Sentence(Word[] value) {
        for (Word word: value) {
            this.value.add(new Word(word));
        }
    }*/

    public Sentence(String value) {
        //this.value[this.value.length]= new Word(value);
        sentenceParser(value);
    }

    public void sentenceParser(String value){
        String[] regexp= value.split("(?<=([ ,:;.]{1}))");
        int countWords = 0;
        for (String reg:regexp) {
            Matcher p = Pattern.compile("([\\w]+)([ ,:;.]{0,1})|([ ,:;.]{1})").matcher(reg);
            p.find();
            if (p.group(3) == null) {
                this.value.add(new Word(p.group(1)));
                this.nonletters.add(new Symbol(countWords, p.group(2).charAt(0)));
                countWords++;
            } else {this.nonletters.add(new Symbol(countWords, p.group(3).charAt(0)));}
        }
    }

    public String getSentence(){
        StringBuilder sentence = new StringBuilder();
        int row = 0;
        int count = 0;
        for (Word word: this.value) {
            sentence.append(word.getValue());
            for (Symbol symbol:nonletters) {
                if (symbol.getWordNumber() == count){
                    sentence.append(symbol.getValue());
                }
            }
        }
        return sentence.toString();
    }

    public static void main(String[] args) {
        //Sentence a = new Sentence("Fsdafasdf asddfas f asdfasdf, : ghjk hjk.");

        //System.out.println(a.getSentence());


        String[] regexp= "Fsdafasdf asddfas f asdfasdf, : ghjk hjk.".split("(?<=([ ,:;.]{1}))");
        for (String reg:regexp) {
            System.out.print("|"+reg+"|");
        }
        System.out.println("\n"+regexp.length);
        System.out.println(regexp[5]);
        Matcher p = Pattern.compile("([\\w]+)([ ,:;.]{0,1})|([ ,:;.]{1})").matcher(regexp[0]);
        p.find();
        System.out.println(p.group(1).toCharArray());
        System.out.print(new Word(p.group(1)));

    }

}
