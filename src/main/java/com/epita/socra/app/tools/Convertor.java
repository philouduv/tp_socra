package com.epita.socra.app.tools;

import java.util.Arrays;
import java.util.List;

public class Convertor implements ConvertorInterface {
    @Override
    public String convert_R_to_A(String number) {
        List<String> romans = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
        List<Integer> ints = Arrays.asList(1000,900,500,400,100,90,50,40,10,9,5,4,1);
        int cpt = 0;
        int number_final = 0;
        while(cpt < number.length()){
            char curr = number.charAt(cpt);
            if ((curr == 'C' || curr == 'X' || curr =='I') && cpt + 1 < number.length()){
                char next = number.charAt(cpt + 1);
                int curr_idx = romans.indexOf(String.valueOf(curr));
                if (curr_idx == -1)
                    return null;
                int next_idx = romans.indexOf(String.valueOf(next));
                if (next_idx == -1)
                    return null;
                if (ints.get(curr_idx) <
                        ints.get(next_idx)){
                    StringBuilder both = new StringBuilder();
                    both.append(curr);
                    both.append(next);
                    int index = romans.indexOf(both.toString());
                    number_final += ints.get(index);
                    cpt++;
                }
                else {
                    int index = romans.indexOf(String.valueOf(curr));
                    if (index == -1)
                        return null;
                    number_final += ints.get(index);
                }
            }
            else
            {
                int index = romans.indexOf(String.valueOf(curr));
                if (index == -1)
                    return null;
                number_final += ints.get(index);
            }
            cpt++;
        }
        return String.valueOf(number_final);
    }

    @Override
    public String convert_A_to_R(String number) {
        Integer num;
        try {
            num = Integer.parseInt(number);
        }
        catch (Exception e) {
            return null;
        }
        if (num <= 0 || num > 3000)
            return null;

        List<String> romans = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
        List<Integer> ints = Arrays.asList(1000,900,500,400,100,90,50,40,10,9,5,4,1);

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
        return res.toString();
    }
}
