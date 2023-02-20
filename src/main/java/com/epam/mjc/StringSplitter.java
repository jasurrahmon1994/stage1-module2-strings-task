package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */

    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
//        throw new UnsupportedOperationException("You should implement this method.");
        List<String> res = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < source.length(); i++) {
            if(delimiters.contains(source.charAt(i) + "")){
                res.add(temp);
                temp = "";
            } else {
                temp += source.charAt(i);
            }
        }
        res.add(temp);
        return res.stream().filter(s -> s.length() > 0).collect(Collectors.toList());
    }
}
