package model;

import java.util.HashSet;

public class Test 
{
    public static void main(String[] args) 
    {
        Periferic p = new Periferic();    

        p.setModel("LG");
        //riga 9 -> invoco il metodo setModel di p
        //chi è this  -> 
        //p, per l'esecuzione del metodo setModel
        //alla riga 9, è THIS

        //chi è il parametro MODEL
        //"LG" dentro parentesi

        //dove finisce il valore "LG" una volta eseguita
        //"LG" diventa il valore della proprietà MODEL
        //dell'oggetto p

        //VETTORE
        // INSIEME                                             tanti elementi
        // di elementi dello stesso tipo                       no VETTORE di String, int e Periferiche, solo di un tipo
        // ORDINATO                                            elementi accessibili tramite indice
        // può contenere duplicati
        // LUNGHEZZA FISSA                                     determiniamo la dimensione alla creazione

        //LISTA
        // INSIEME                                             tanti elementi
        // di OGGETTI dello stesso tipo                        no VETTORE di String,  Periferiche, solo di un tipo
        // ORDINATO                                            elementi accessibili tramite indice
        // può contenere duplicati
        // LUNGHEZZA VARIABILE                                aumenta e diminuisce inserendo o rimuovendo oggetti

         //SET                (NON C'ENTRA NULLA!!11!!!! con i SETTER)
        // INSIEME                                             tanti elementi
        // di OGGETTI dello stesso tipo                        no VETTORE di String,  Periferiche, solo di un tipo
        // NON ORDINATO                                        non ho gli indici
        // NON può contenere duplicati
        // LUNGHEZZA VARIABILE                                aumenta e diminuisce inserendo o rimuovendo oggetti

        //uno dei suoi utilizzi principali è il controllo di ESISTENZA

        HashSet<String> paroleVincenti = new HashSet<>();

        paroleVincenti.add("pippo");
        paroleVincenti.add("pluto");
        paroleVincenti.add("paperino");

        String parolaInserita = "pluto";

        //contains restituisce TRUE se l'oggetto è già presente nel SET
        //FALSE se non lo è
        System.out.println("La parola è vincente: "+ paroleVincenti.contains(parolaInserita));
    }
}
