package com.epam.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Munar on 02.03.2016.
 */
public class Text {
    private List<Paragraph> value = new ArrayList<Paragraph>();
    private List<String> nonletters = new ArrayList<String>();

    Text(String value){
        textParser(value);
    }

    public void textParser(String value){
        String[] paragraphs= value.split("(?<=(\\n\\n))");
        for (String paragraph: paragraphs) {
            Matcher p = Pattern.compile("([[^\\w]\n\n]+)").matcher(paragraph);
            p.find();
            this.value.add(new Paragraph(paragraph));
            this.nonletters.add(p.group(1));
            }
    }

    public String getText(){
        StringBuilder text = new StringBuilder();
        int dblEnter=0;
        String str;
        for (Paragraph paragraph: this.value) {
            if (dblEnter < this.value.size()-1) str="\n"; else{str="";}
            text.append(paragraph.getParagraph());
            dblEnter++;
        }
        return text.toString();
    }

    public static void main(String[] args) {
        String str = "Мне так просто и радостно снилось:\n" +
                "ты стояла одна на крыльце\n" +
                "и рукой от зари заслонилась,\n" +
                "а заря у тебя на лице." +
                "\n\n" +
                "Упадали легко и росисто\n" +
                "луч на платье и тень на порог,\n" +
                "а в саду каждый листик лучистый\n" +
                "улыбался, как маленький бог." +
                "\n\n" +
                "Ты глядела, мое сновиденье,\n" +
                "в глубину голубую аллей,\n" +
                "и сквозное листвы отраженье\n" +
                "трепетало на шее твоей." +
                "\n\n" +
                "Я не знаю, что все это значит,\n" +
                "почему я проснулся в слезах…\n" +
                "Кто-то в сердце смеется и плачет,\n" +
                "и стоишь ты на солнце в дверях.";
        Text text = new Text(str);
        System.out.println(text.getText().equals(str));
        System.out.println(text.getText());
        System.out.println("\n--------------------------------------\n"+str.length());
        /*String[] paragraph = text.split("(?<=(\\n))");
        String[] sentence = paragraph[0].split("(?<=([.!?]{1,3}))");
        System.out.println(sentence[2]);*/
    }
}
