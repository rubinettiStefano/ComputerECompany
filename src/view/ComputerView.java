package view;

import java.util.ArrayList;

import model.Computer;

public class ComputerView 
{

    private PerifericView pView = new PerifericView();

    //per renderizzare un singolo computer posso richiamare
    //1 render(c)
    //2 render(c,true)
    //3 render(c,false)

    //1 e 2 sono identici, renderizzano con periferiche
    //3 renderizza senza periferiche


    //grafica il computer con tutte le periferiche
    public String render(Computer c)
    {
        return render(c, true);
    }

    //grafica una lista di computer con tutte le periferiche
    public String render(ArrayList<Computer> computers)
    {
        return render(computers, true);
    }

    //grafica il computer con tutte le periferiche se il boolean è true
    //senza se è false
    public String render(Computer c, boolean renderPeriferics)
    {
        String res = "";
        if(c.getId()==null)
            res+="Sono un computer non ancora nel db,";
        else
            res+="Sono un computer del db con id "+c.getId()+",";

        res+=   "ho "+c.getRamSize()+" gb di ram, ho un "+c.getMmaType()+" di "+c.getMmaSize()+" gb, una cpu "+
                c.getCpu()+" e una gpu "+c.getGpu()+", costo "+c.getTotalPrice();

        if(renderPeriferics)
            res+=" \n"+pView.render(c.getPeriferics());//se voglio renderizzo anche le sue periferiche

        return res;
        
    }

    //grafica una lista di computer con tutte le periferiche se il boolean è true
    //senza se è false
    public String render(ArrayList<Computer> computers, boolean renderPeriferics)
    {
        String res ="Lista di computer";

        for(Computer c: computers)
            res+="\n"+render(c,renderPeriferics);

        return res;
    }
}
