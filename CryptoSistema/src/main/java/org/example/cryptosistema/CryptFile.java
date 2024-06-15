package org.example.cryptosistema;

import java.io.*;

public class CryptFile {
    void writeCryptFile(String str) throws IOException {
        BufferedWriter wfile = new BufferedWriter(new FileWriter("CryptFile.txt"));
        wfile.write(str);
        wfile.close();
    }
    void writeDecryptFile(String str) throws IOException {
        BufferedWriter wfile = new BufferedWriter(new FileWriter("DecryptFile.txt"));
        wfile.write(str);
        wfile.close();
    }
    StringBuilder readCryptFile() throws IOException {
        String str;
        StringBuilder str1 = new StringBuilder();

        BufferedReader rfile = new BufferedReader(new FileReader("CryptFile.txt"));
        while((str = rfile.readLine()) != null){
            str1.append(str+"\n");
        }
        rfile.close();
        return str1;
    }
    StringBuilder readDecryptFile() throws IOException {
        String str;
        StringBuilder str1 = new StringBuilder();

        BufferedReader rfile = new BufferedReader(new FileReader("DecryptFile.txt"));
        while((str = rfile.readLine()) != null){
            str1.append(str+"\n");
        }
        rfile.close();
        return str1;
    }
}
