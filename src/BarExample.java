import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarExample {

	private int[] theArray;

	private int arraySize;

	ChartPanel chartPanel;

	JLabel intervalLabel;

	DefaultCategoryDataset dataset;

	public BarExample(int arraySize) {

		this.arraySize = arraySize;

		theArray = new int[arraySize];

		JFrame theFrame = new JFrame();

		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JInternalFrame theInnerFrame = new JInternalFrame("Chart", true, true, true, true);

		dataset = new DefaultCategoryDataset();

		generateRandom(dataset);

//		JFreeChart chart = ChartFactory.createBarChart("Shell Sort",
//				"Random Values", "Values", dataset, PlotOrientation.VERTICAL,
//				false, true, false);
		
		JFreeChart chart = ChartFactory.createBarChart("Bubble Sort",
				"Random Values", "Values", dataset, PlotOrientation.VERTICAL,
				false, true, false);

		chart.setBackgroundPaint(Color.white);
		chart.getTitle().setPaint(Color.black);

		CategoryPlot p = chart.getCategoryPlot();

		CategoryItemRenderer renderer = new DifferenceBarRenderer();

		p.setRenderer(renderer);

		p.setRangeGridlinePaint(Color.blue);

		chartPanel = new ChartPanel(chart);

		theInnerFrame.add(chartPanel);

		intervalLabel = new JLabel("mo phong thuat toan");

		intervalLabel.setFont(new Font("SansSerif", Font.PLAIN, 30));

		intervalLabel.setHorizontalAlignment(JLabel.CENTER);

		theInnerFrame.pack();

		theInnerFrame.setVisible(true);

		chartPanel.setSize(900, 500);

		theFrame.add(theInnerFrame, BorderLayout.CENTER);

		theFrame.add(intervalLabel, BorderLayout.NORTH);

		theFrame.setSize(1200, 600);

		theFrame.setLocationRelativeTo(null);

		theFrame.setVisible(true);

//		bubbleSort();
		shellSort();
	}

	public void generateRandom(DefaultCategoryDataset dataset) {

		for (int i = 0; i < arraySize; i++) {

			theArray[i] = (int) (Math.random() * 40) + 10;

			dataset.setValue((int) (Math.random() * 40) + 10, "Value",
					Integer.toString(i));
		}

	}

	public void updateBar(DefaultCategoryDataset dataset) {

		for (int i = 0; i < arraySize; i++) {

			dataset.setValue(theArray[i], "Value", Integer.toString(i));

		}

		chartPanel.repaint();

	}

	public void bubbleSort() {
		int i ,k ,temp;
	
		for ( i = 0 ; i < arraySize; i ++){
            for ( k = i ; k < arraySize ; k ++){
                if (theArray[i] > theArray[k]){
                    temp = theArray[i];
                    theArray[i] = theArray[k];
                    theArray[k] = temp;
                    	
                    updateBar(dataset);
                    try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        }
	}
	
	public void shellSort() {

		int inner, outer, temp;

		int interval = 1;

		while (interval <= arraySize / 3)

			interval = interval * 3 + 1;


		while (interval > 0) {

			for (outer = interval; outer < arraySize; outer++) {

				temp = theArray[outer];

				inner = outer;

				while (inner > interval - 1
						&& theArray[inner - interval] >= temp) {

					theArray[inner] = theArray[inner - interval];

					inner -= interval;

				}

				theArray[inner] = temp;

				updateBar(dataset);

				try {

					intervalLabel.setText("INTERVAL : " + interval);

					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			interval = (interval - 1) / 3;
		}

	}

	public static void main(String[] args) {

		new BarExample(50);

	}

}

class DifferenceBarRenderer extends BarRenderer {
	public DifferenceBarRenderer() {
		super();
	}

	public Paint getItemPaint(int x_row, int x_col) {
		return Color.blue;
	}
}