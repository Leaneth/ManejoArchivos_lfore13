//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivos {

    public static void main(String[] args) {
        String ruta = "D://fundamentos-programacion//repositorio-github//manejoArchivos//ManejoArchivos//";
        File file = new File(ruta + "test.txt");
        System.out.println(file.exists());

        try {
            FileReader fr = new FileReader(file);

            try {
                BufferedReader br = new BufferedReader(fr);
                promedio(br);

                String linea;
                while((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (Throwable var7) {
                try {
                    fr.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            fr.close();
        } catch (Exception var8) {
            throw new RuntimeException(var8);
        }
    }

    public static void promedio(BufferedReader br) {
        int suma = 0;
        int contador = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        try {
            String linea;
            while((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\s+");
                String[] var7 = partes;
                int var8 = partes.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    String parte = var7[var9];

                    try {
                        int numero = Integer.parseInt(parte);
                        suma += numero;
                        ++contador;
                        if (numero > max) {
                            max = numero;
                        }

                        if (numero < min) {
                            min = numero;
                        }
                    } catch (NumberFormatException var12) {
                    }
                }
            }

            if (contador > 0) {
                double promedio = (double)suma / (double)contador;
                System.out.println("Promedio: " + promedio);
                System.out.println("Número mayor: " + max);
                System.out.println("Número menor: " + min);
            } else {
                System.out.println("No se encontraron números válidos en el archivo.");
            }
        } catch (IOException var13) {
            System.out.println("Error al leer el archivo: " + var13.getMessage());
        }

    }
}
