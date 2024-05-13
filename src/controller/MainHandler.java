package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Computer;
import model.Periferic;
import repository.DatabaseHandler;
import view.ComputerView;
import view.PerifericView;

public class MainHandler 
{
    private static Scanner term = new Scanner(System.in);
    private static DatabaseHandler dbh = new DatabaseHandler();
    private static ComputerView cView = new ComputerView();
    private static PerifericView pView = new PerifericView();

    public static void readPcs()
    {
        System.out.println("Vuoi stampare anche le periferiche? (y/n)");
        boolean wantPeriferics = term.nextLine().equalsIgnoreCase("y");

        ArrayList<Computer> allPcs = dbh.readComputer();

        String output = cView.render(allPcs, wantPeriferics);

        System.out.println(output);
    }

    public static void insertPc()
    {
        Computer pc = new Computer();
        System.out.println("Inserisci gb ram");
        pc.setRamSize(Integer.parseInt(term.nextLine()));
        System.out.println("Inserisci gb mma");
        pc.setMmaSize(Integer.parseInt(term.nextLine()));
        System.out.println("Inserisci prezzo");
        pc.setPrice(Integer.parseInt(term.nextLine()));
        System.out.println("Inserisci tipologia mma");
        pc.setMmaType(term.nextLine());
        System.out.println("Inserisci cpu");
        pc.setCpu(term.nextLine());
        System.out.println("Inserisci gpu");
        pc.setGpu(term.nextLine());

        System.out.println("Questo è il pc, lo vuoi inserire?(y/n)");
        System.out.println(cView.render(pc, false));

        boolean insert = term.nextLine().equalsIgnoreCase("y");

        if(insert)
        {
            dbh.insertComputer(pc);
            System.out.println("PC INSERITO");
        }
        else
        {
            System.out.println("Inserimento annullato");
        }

    }

    public static void insertPeriferic()
    {
        ArrayList<Computer> allPcs = dbh.readComputer();

        String output = cView.render(allPcs, false);

        System.out.println(output);

        Periferic p = new Periferic();

        System.out.println("Inserisci id del pc a cui vuoi assegnare questa periferica");
        p.setComputer_id(Integer.parseInt(term.nextLine()));
        System.out.println("Inserisci prezzo");
        p.setPrice(Integer.parseInt(term.nextLine()));
        System.out.println("Inserisci tipo");
        p.setType(term.nextLine());
        System.out.println("Inserisci modello");
        p.setModel(term.nextLine());
        
        System.out.println("Questo è la periferica, la vuoi inserire?(y/n)");
        System.out.println(pView.render(p));

        boolean insert = term.nextLine().equalsIgnoreCase("y");

        if(insert)
        {
            dbh.insertPeriferic(p);
            System.out.println("Periferica inserita");
        }
        else
        {
            System.out.println("Inserimento annullato");
        }

    }

    public static void updatePc()
    {
        ArrayList<Computer> allPcs = dbh.readComputer();

        String output = cView.render(allPcs, false);

        System.out.println(output);


        System.out.println("Inserisci id del pc da modificare");
        int id = Integer.parseInt(term.nextLine());

        Computer toUpdate = dbh.readComputer(id);

        String in;
        System.out.println("Inserisci gb ram (invio per lasciare uguale)");
        in = term.nextLine();
        if(!in.isBlank())
            toUpdate.setRamSize(Integer.parseInt(in));


        System.out.println("Inserisci gb mma");
        in = term.nextLine();
        if(!in.isBlank())
            toUpdate.setMmaSize(Integer.parseInt(in));
        System.out.println("Inserisci prezzo");
        in = term.nextLine();
        if(!in.isBlank())
            toUpdate.setPrice(Integer.parseInt(in));
        System.out.println("Inserisci tipologia mma");
        in = term.nextLine();
        if(!in.isBlank())
            toUpdate.setMmaType(in);
        System.out.println("Inserisci cpu");
        in = term.nextLine();
        if(!in.isBlank())
            toUpdate.setCpu(in);
        System.out.println("Inserisci gpu");
        in = term.nextLine();
        if(!in.isBlank())
            toUpdate.setGpu(in);

        System.out.println("Questo è il pc con i cambiamenti, confermi?(y/n)");
        System.out.println(cView.render(toUpdate, false));

        boolean insert = term.nextLine().equalsIgnoreCase("y");

        if(insert)
        {
            dbh.updateComputer(toUpdate);
            System.out.println("PC modificato");
        }
        else
        {
            System.out.println("Inserimento annullato");
        }

    }

    public static void deletePc()
    {
        ArrayList<Computer> allPcs = dbh.readComputer();

        String output = cView.render(allPcs, false);

        System.out.println(output);

        System.out.println("Inserisci id del pc da cancellare, vuoto per saltare la cancellazione");
        String in = term.nextLine();
        if(!in.isBlank())
        {
            int id = Integer.parseInt(in);

            dbh.deleteComputer(id);
    
            System.out.println("Cancellato con successo");
        }
        else    
            System.out.println("Cancellazione annullata");
       
    }


}
