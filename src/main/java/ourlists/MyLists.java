package ourlists;

public class MyLists implements MyList{


    private MyElement firstElement;
    private MyElement lastElement;
    private int size;

    public MyLists() {
        this.firstElement = null;
    }




    public void add(String myElementString) {
        size = size +1;
        MyElement myElementToAdd = new MyElement(myElementString);

        if (listIsEmpty()){
            this.firstElement = myElementToAdd;
            this.lastElement = myElementToAdd;

        }
        else{
            MyElement temporaryElement = this.lastElement;
            temporaryElement.setNextElement(myElementToAdd);
            this.lastElement = myElementToAdd;
        }


}

public String returnListAsString(){
        //string ktory ma zwrocic poniedzialek, wtorek...

    String wynik = "";
    MyElement temporary = this.firstElement;
    while (temporary !=null){
        wynik += temporary.getMyString() + ",";
        temporary = temporary.getNextElement();
    }
        return wynik;

}

public String poka(){

        return firstElement.getMyString() + "," + lastElement.getMyString();
}



public int getSize(){
       return size;


}

    public void remove(String element) {
        MyElement temporary;
        MyElement temporaryPrev;//pomocnicza trzymajaca w sobie element wczesniejszy
        MyElement temporaryNext;//pomocnicza trzymajaca w sobie element nastepny
        MyElement temporaryCurrent;

        if (this.firstElement.getMyString() == element){
            temporary = this.firstElement;//obiekt pomocniczy
            this.firstElement = this.firstElement.getNextElement();//zmienia pierwszy element na drugi
//            temporary.setNextElement(null);//nadaje pierwszemu elementowi (jako temporary) wskaznika null zeby na nic nie wskazywal
        }

        else {// usuwamy jakis element srodkowy
             temporaryPrev = firstElement;

            temporaryCurrent = firstElement.getNextElement();
            temporaryNext = temporaryCurrent.getNextElement();

            while (!temporaryCurrent.getMyString().equals(element)) {
                temporaryPrev = temporaryCurrent;
                temporaryCurrent = temporaryCurrent.getNextElement();
                temporaryNext = temporaryCurrent.getNextElement();
            }

            if (temporaryCurrent.getMyString().equals (lastElement.getMyString())){
                this.lastElement = temporaryPrev;

            temporaryPrev.setNextElement(temporaryNext);

            size--;
        }


        }

        // 3 warianty maja byc:
        //1. usuwanie pierwszego: przestawic firstElement na 'drugi' element listy
        // w usuwanym elemencie przestawic wskaznik next na null
        //2. usuwanie srodkowego
    }

    private boolean listIsEmpty(){
        return this.firstElement ==null;
}


}
