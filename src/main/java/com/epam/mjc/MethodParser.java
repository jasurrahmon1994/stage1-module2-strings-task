package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */

    public MethodSignature parseFunction(String signatureString) {
//        throw new UnsupportedOperationException("You should implement this method.");
        List<MethodSignature.Argument> args = new ArrayList<>();
        int braceIndex = signatureString.indexOf("(");
        String argStr = signatureString.substring(braceIndex + 1, signatureString.length() - 1);
        if(argStr.length() > 0){
            String[] split = argStr.split(", ");
            for (int i = 0; i < split.length; i++) {
                String[] s = split[i].split(" ");
                MethodSignature.Argument argument = new MethodSignature.Argument(s[0], s[1]);
                args.add(i, argument);
            }
        }
        String methodStr = signatureString.substring(0, braceIndex);
        String[] s = methodStr.split(" ");
        String acMod, retType, metName;
        if(s.length == 2){
            acMod = null;
            retType = s[0];
            metName = s[1];
        } else {
            metName = s[2];
            acMod = s[0];
            retType = s[1];
        }
        MethodSignature ms = new MethodSignature(metName, args);
        ms.setAccessModifier(acMod);
        ms.setReturnType(retType);
        return ms;
    }
}
