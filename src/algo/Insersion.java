package algo;


import element.Element;
import element.ElementArray;

public class Insersion implements Algorithm {
    private static Insersion ourInstance = new Insersion();

    public static Insersion getInstance() {
        return ourInstance;
    }

    private Insersion() {
    }

    public void sort(ElementArray arr) {

    	int i, j;
    	for (i = 1; i < arr.length(); i++) {
    		Element key = arr.getElementAt(i);
    		j = i - 1;
    		while (j >= 0 && arr.compare(key.getIndex(), j) > 0) {
    			arr.swap(j, j+1);
    			j--;
    		}
    	}
    	
    	for (Element e: arr.getAll()) {
    		System.out.print(e.getValue()+" " );
    	}

	}

    @Override
    public String toString() {
        return "Insersion";
    }
}