package algo;

import element.Element;
import element.ElementArray;

public class Shell implements Algorithm {
    private static Shell ourInstance = new Shell();

    public static Shell getInstance() {
        return ourInstance;
    }

    private Shell() {
    }

    public void sort(ElementArray arr) {
    	
    	int inner, outer;
		int interval = 1;

		while (interval <= arr.length() / 3)
			interval = interval * 3 + 1;
	
		while (interval > 0) {
			System.out.println("interval : " + interval);
			for (outer = interval; outer < arr.length(); outer++) {
				Element temp = arr.getElementAt(outer);
				inner = outer;

				while (inner > interval - 1	&& arr.compare(temp.getIndex(),inner - interval) >=0 ) {

					arr.swap(inner, inner - interval);
					inner -= interval;
				}
				
				arr.swap(temp.getIndex(), arr.getElementAt(inner).getIndex());
				
			}
			interval = (interval - 1) / 3;
		}
		
//		 int length = arr.length();
//	        for (int i = 0; i < length; i++) {
//	            int minIndex = i;
//	            for (int j = i + 1; j < length; j++) {
//	                if (arr.compare(j, minIndex) > 0)
//	                    minIndex = j;
//	            }
//	            arr.swap(i, minIndex);
//	            // Sorted Point
//	        }

	}

    @Override
    public String toString() {
        return "Shell";
    }
}