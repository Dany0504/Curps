package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Escribe el nombre del archivo como argumento");
            return;
        }

        String datos = args[0];
        String ValidacionCurp = "^[A-Z]{1}[AEIOU]{1}[A-Z]{2}\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])[HM](AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[B-DF-HJ-NP-TV-Z]{3}[A-Z0-9]{2}$";
        Pattern pattern = Pattern.compile(ValidacionCurp);

        try (BufferedReader lector = new BufferedReader(new FileReader(datos))) {
            String linea;
            int posicion = 1;

            while ((linea = lector.readLine()) != null) {
                Matcher matcher = pattern.matcher(linea);
                if (!matcher.matches()) {
                    System.out.println("CURP inválida: " + linea + " en la posición " + posicion);
                }
                posicion++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
