/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author thippeswamy
 */
public class NewClass {
    public static void main(String[] args) {
        PrintWriter writer;
        try {
            writer = new PrintWriter("F:\\thippeswamy\\program\\NetBeansProjects\\java_ticTacToe\\src\\files\\xcount.txt", "UTF-8");
            writer.println(("line 11111111111"));
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
        }
    }
}
