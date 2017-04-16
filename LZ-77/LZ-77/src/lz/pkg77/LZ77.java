package lz.pkg77;

import java.util.*;

public class LZ77 {

    private String word;
    ArrayList<Tag> myTags;

    public LZ77() {
    }

    public LZ77(String word) {
        this.word = word;
        this.myTags = new ArrayList<>();
    }

    public void setWord(String word) {
        this.word = word;
        this.myTags = new ArrayList<>();
    }

    public String getWord() {
        return word;
    }

    public Tag getTag(String nextChar, String compressed, boolean lastIndex) {
        String split = nextChar.substring(nextChar.length() - 1);
        String comp = nextChar.substring(0, nextChar.length() - 1);
        int length, indexmatch, pointer;
        length = comp.length();
        if (comp.length() == 0) {
            pointer = 0;
        } else {
            if (lastIndex == false) {
                indexmatch = compressed.indexOf(comp);
            } else {
                indexmatch = compressed.lastIndexOf(comp);
            }
            pointer = compressed.length() - indexmatch;
        }
        Tag newTag = new Tag(pointer, length, split);
        return newTag;
    }

    public void Compress(ArrayList<Tag> myTags) {
        ArrayList<Character> seq = new ArrayList<>();
        String nextChar = "";
        String compressed = "";
        boolean lastIndex = false;
        int tagsno = 0, maxlength = 0, maxpointer = 0;
        for (int i = 0; i < word.length(); i++) {
            seq.add(word.charAt(i));
            nextChar = "";
            for (int j = 0; j < seq.size(); j++) {
                nextChar += seq.get(j);
            }
            if (compressed.contains(nextChar) && i == word.length() - 1) {
                lastIndex = true;
                myTags.add(getTag(nextChar, compressed, lastIndex));
                if (nextChar.length() > maxpointer) {
                    maxpointer = nextChar.length();
                }
                if ((nextChar.length() - 1) > maxlength) {
                    maxlength = nextChar.length() - 1;
                }
                compressed = compressed.concat(nextChar);
                seq.clear();
                tagsno++;
            } 
            else if (compressed.contains(nextChar)) {
            } 
            else {
                myTags.add(getTag(nextChar, compressed, lastIndex));
                compressed = compressed.concat(nextChar);
                if (nextChar.length() > maxpointer) {
                    maxpointer = nextChar.length();
                }
                if ((nextChar.length() - 1) > maxlength) {
                    maxlength = nextChar.length() - 1;
                }
                seq.clear();
                tagsno++;
            }

        }
        System.out.println("The text is : " + word);
        System.out.println("the original = : " + word.length() + " * " + "7 bit = " + word.length() * 7);
        System.out.println("the compession = : " + tagsno + " * (" + Integer.toBinaryString(maxpointer).length() + " + " + Integer.toBinaryString(maxlength).length() + " + 7" + ") = " + tagsno * (Integer.toBinaryString(maxpointer).length() + Integer.toBinaryString(maxlength).length() + 7));
    }

    public static void main(String[] args) {
        LZ77GUI myForm = new LZ77GUI();
        myForm.show();
//        Scanner input = new Scanner(System.in);
//        System.out.println("Press -> 1 : Compress\n" + "Press -> 2 : Decompress");
//        int choice;
//        choice = input.nextInt();
//        if (choice == 1) {
//            System.out.println("Enter Your Text:");
//            String text;
//            text = input.nextLine();
//            LZ77 myobj = new LZ77(text);
//            ArrayList<Tag> myTags = new ArrayList<>();
//            myobj.Compress(myTags);
//            System.out.println(myTags);
//        } 
//        else if (choice == 2) {
//            ArrayList<Character> sbuffer = new ArrayList<>();
//            String text = "";
//            int textlength = 0;
//            int tagsno;
//
//            System.out.println("Enter the number of tags for the text : ");
//            tagsno = input.nextInt();
//            for (int i = 0; i < tagsno; i++) {
//                int pointer, length;
//                String nextchar;
//
//                System.out.println("Enter the information of tag : ");
//                System.out.print("Enter the pointer : ");
//                pointer = input.nextInt();
//                System.out.print("Enter the length : ");
//                length = input.nextInt();
//                input.nextLine();
//                System.out.print("Enter the nextchar : ");
//                nextchar = input.nextLine();
//
//                if (length == 0 && pointer == 0) {
//                    text = text.concat(nextchar);
//                    textlength++;
//                } 
//                else {
//                    int temp = textlength - pointer;
//                    for (int j = 0; j < length; j++) {
//                        sbuffer.add(text.charAt(temp));
//                        temp++;
//                    }
//                    String smallbuffer = "";
//                    for (Character c : sbuffer)//convert array of  characters to strings
//                    {
//                        smallbuffer += c;
//                    }
//                    System.out.println("small buffer" + smallbuffer);
//
//                    sbuffer.clear();
//                    text = text.concat(smallbuffer);
//                    textlength = textlength + smallbuffer.length();
//                    text = text.concat(nextchar);
//                    textlength++;
//                }
//            }
//            System.out.println(text);
//        }

    }

}
