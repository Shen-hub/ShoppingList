package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args){
        String name;
        String product;
        int count;
        TreeMap<String, TreeMap<String,Integer>> customers =  new TreeMap<>();

        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(" ");
        while(!str[0].isEmpty())
        {
            TreeMap<String, Integer> products = new TreeMap<>();
            name = str[0];
            product = str[1];
            count = Integer.parseInt(str[2]);

            if (customers.containsKey(name))
            {
                products = customers.get(name);
                if (products.containsKey(product))
                {
                    count += products.get(product);
                }
            }
            products.put(product, count);
            customers.put(name, products);
            str = sc.nextLine().split(" ");
        }

        for (String customer: customers.keySet())
        {
            System.out.println(customer+":");
            for (String prod: customers.get(customer).keySet())
            {
                System.out.println(prod+" "+customers.get(customer).get(prod));
            }
            System.out.print('\n');
        }
    }
}
