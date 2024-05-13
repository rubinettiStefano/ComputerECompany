package controller;

import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner term = new Scanner(System.in);
        
        String cmd;

        do
        {
            System.out.println("Insert command");
            cmd = term.nextLine().toLowerCase();

            switch (cmd) 
            {
                case "read pcs":
                    MainHandler.readPcs();
                break;
                case "insert pc":
                    MainHandler.insertPc();
                break;
                case "insert periferic":
                    MainHandler.insertPeriferic();
                break;
                case "update pc":
                    MainHandler.updatePc();
                break;
                case "delete pc":
                    MainHandler.deletePc();
                break;
                case "help":
                    help();
                break;
                case "quit":
                    System.out.println("TERMINATED");
                break;
                default:
                    System.out.println("Invalid Command");
                break;
            }



        }while(!cmd.equals("quit"));
    }

    private static void help()
    {
        String res = "I comandi sono:\n"+
                     "read pcs -> legge tutti i pc \n"+
                     "insert pc -> inserisce un nuovo pc";
        System.out.println(res);
    }
}
