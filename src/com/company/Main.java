package com.company;
import java.io.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int x = in.nextInt();
            Formula form = new Formula(x);
            form.displayFormula();
            System.out.print("Enter a word 1 ");
            String st1 = in.next();
            while (true) {
                if ("save".equals(st1)) {
                    try (ObjectOutputStream fww = new ObjectOutputStream(new FileOutputStream("src//lb14.txt"))) {
                        fww.writeObject(form);
                        fww.writeInt(x);
                        System.out.println("OK");

                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    System.out.println("Error");
                }
                break;

            }
                System.out.print("Enter a word 2 ");
                String st = in.next();
                if ("upload".equals(st)) {
                    try (ObjectInputStream pt = new ObjectInputStream(new FileInputStream("src//lb14.txt"))) {
                        Formula did = (Formula) pt.readObject();
                        System.out.println(did.x);
                        System.out.println("OK2");
                    } catch (IOException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("Error2");
                    break;
                }
            }
        }
    }


class Formula implements Serializable {
    float x;

    public Formula(float x) {
        this.x = x;
    }

    public void displayFormula() {
        double vector = x - (Math.sin(x));
        System.out.println(vector);
    }
}
