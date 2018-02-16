package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args){
        String s;
        Scanner in = new Scanner(System.in);
        s = in.nextLine(); //assuming all alphabets are in small case.
        int i = 0, j = 0, cha = 0;
        char a;
        int count[] = new int[26];
        Arrays.fill(count, 0);
        while(i < s.length()){
            if(s.charAt(i) != ' '){
                j = s.charAt(i) - 'a';
                if(count[j] == 0)
                    cha++;
                count[j]++;
            }
            i++;
        }
        heap h = new heap(cha + 1);
        for(i = 0; i < 26; i++){
            if(count[i] != 0){
                a = (char)(i + 97);
                node n = new node(count[i], a);
                h.add(n);
            }
        }
      // h.print();
        node root = h.convertTo();
        node n = new node();
       // n.preorder(root);
        for(i = 0; i < 26; i++){
            StringBuilder sb = new StringBuilder();
            if(count[i] != 0){
                a = (char)(i + 97);
                n.codeValue(root, root, a, sb, count[i]);
            }
        }


    }
}
