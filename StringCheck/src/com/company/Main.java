package com.company;

public class Main {

    public static void main(String[] args)
    {
        String url = "http:/11111111111111";

        if(!url.startsWith("http://",0))
        {
            System.out.println("mat");
        }
        System.out.println(url.charAt(0));
        System.out.println(url.charAt(1));
        System.out.println(url.charAt(2));
        System.out.println(url.charAt(3));
        System.out.println(url.charAt(4));
    }
}
