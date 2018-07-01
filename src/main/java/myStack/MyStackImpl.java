package myStack;

import java.util.EmptyStackException;

public class MyStackImpl implements MyStack {

    private int size = 0;


    MyStackElem first;


    public void push(MyStackElem stackElem) {
        size++;
        stackElem.setNext(first);//dodajemy nowy element
        this.first = stackElem;//przestawiamy wskaznik first na ten nowy
    }


    public MyStackElem pop() {
        size--;
    if (!isEmpty()) {
        MyStackElem temporary = this.first;
        this.first = this.first.getNext();

        return temporary;
    }
//    return null;//to nie jest optymalne rozwiazanie
        throw new EmptyStackException();


    }




    public int size() {
        return size;
       }



    public String getAllElementOfStack() {
        MyStackElem temp = first;
        String result = "";
        while (temp != null){
            result += temp.getContent();
            temp = temp.getNext();
        }
        return result;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
