package ourlists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {

    public static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main (String[] args){

        logger.info("TEST");

        MyList myList = new MyLists();
        myList.add("poniedzialek");
        myList.add("wtorek");
        myList.add("sroda");
        myList.add("czwartek");
        myList.add("piatek");



        myList.remove("piatek");
        logger.info("wyciety piatek: {}",(myList).returnListAsString());
        logger.info("rozmiar tabeli to:  {}", myList.getSize());// tu musi byc tyle zestawow klamerek co potem parametrow
        logger.info("poczatek i koniec: {}", myList.poka());





        }

        //chcemy utworzyc wlasna liste,
        // 1. dodac wartosci kolejno dni tygodnia
        // 2. wyswietlenie wszystkich elementow listy
        // 3. zwrocenie rozmiaru listy
        // 4. usuniecie elementu z listy
    }

