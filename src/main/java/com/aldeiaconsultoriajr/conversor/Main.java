package com.aldeiaconsultoriajr.conversor;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        com.aldeiaconsultoriajr.nfe.pr.ibaiti.LeitorXML leitor = new com.aldeiaconsultoriajr.nfe.pr.ibaiti.LeitorXML();
        com.aldeiaconsultoriajr.nfe.pr.ibaiti.ListaNfs listaNfs = leitor.lerXML("ibaiti.xml");
        System.out.println(listaNfs.getNfs().size());
    }
}
