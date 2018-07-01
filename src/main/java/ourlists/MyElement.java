package ourlists;

public class MyElement {

    private String myString;
    private MyElement nextElement;

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public MyElement getNextElement() {
        return nextElement;
    }

    public void setNextElement(MyElement nextElement) {
        this.nextElement = nextElement;
    }

    public MyElement (String myElementString){
        this.myString = myElementString;
        this.nextElement = null;


    }

}
