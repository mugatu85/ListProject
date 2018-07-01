package myStack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("TEST");

        logger.info("begin");
        MyStackElem<String> jan = new MyStackElem("January");///<String> jest konsekwencja dodania T w klasie MyStackElem
        MyStackElem<String> feb = new MyStackElem("February");
        MyStackElem<String> mar = new MyStackElem("March");
        MyStackElem<String> apr = new MyStackElem("April");

        MyStack myStack = new MyStackImpl();
        myStack.push(jan);
        myStack.push(feb);
        myStack.push(mar);///wrzucone 3 w normalnej kolejnosci



        logger.info("myStack {}",myStack.pop().getContent());//zdejmuje i wyswietla pierwszy z gory i juz potem go nie ma
        logger.info("myStack {}",myStack.pop().getContent());//zdejmuje kolejny z gory i usuwa go
        myStack.push(apr);//dodaje kwiecien
        logger.info("myStack {}",myStack.pop().getContent());//wyswietla kolejny z gory i zdejmuje go
        logger.info("myStack {}",myStack.pop().getContent());

        //mozna dodawac elementy ktorych wczesniej nie bylo na stosie ale nie mozna zdejmowac wiecej niz na nim jest
        // dodac wyswietlanie do wszystkich metod
        //zrobic to co robert doslal na gita na nast tydzien





        logger.info("end");
    }
}
