package com.company;

public class node {
    int count;
    char c;
    node left;
    node right;
    public node(){
    }
    public node(int c, char s){
        this.count = c;
        this.c = s;
        this.left = null;
        this.right = null;
    }
    public void preorder(node n){
        if(n == null)
            return;
        System.out.println(n.count+" "+n.c);
        preorder(n.left);
        preorder(n.right);
    }
    public node(node n1, node n2){
        this.count = n1.count + n2.count;
        this.c = '*';
        this.left = n1;
        this.right = n2;
    }
    public int getCount(){
        return this.count;
    }
    public char getC(){
        return this.c;
    }
    public void codeValue(node r, node root, char c1, StringBuilder s, int co){
        if(r == null)
            return;
        if(r.count == co && c1 == r.c)
            System.out.println(r.c+" "+c1+" "+s);
        codeValue(r.left, root, c1, s.append('0'), co);
        codeValue(r.right, root, c1, s.append('1'), co);
    }
}
