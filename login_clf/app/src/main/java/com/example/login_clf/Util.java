package com.example.login_clf;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {
    public static String readString(BufferedReader reader) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            return "";
        }
        return stringBuilder.toString();
    }
}
