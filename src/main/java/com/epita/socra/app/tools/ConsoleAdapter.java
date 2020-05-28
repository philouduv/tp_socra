package com.epita.socra.app.tools;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleAdapter implements IOAdapter {

    private Scanner scan = new Scanner(System.in);

    @Override
    public String read() {
        return scan.nextLine();
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }


    @Override
    public String convert(String number) {
        List<String> romans = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
        List<Integer> ints = Arrays.asList(1000,900,500,400,100,90,50,40,10,9,5,4,1);

        Integer num = Integer.getInteger(number);
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (num > 0)
        {
            while (num >= ints.get(i))
            {
                res.append(romans.get(i));
                num -= ints.get(i);
            }
            i++;
        }
        return "res.toString()";
    }


}
