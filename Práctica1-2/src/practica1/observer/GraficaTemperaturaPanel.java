package practica1.observer;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficaTemperaturaPanel extends JPanel implements Observador{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private XYSeries temperaturas;
	private int dataWindowSize;
	private int numberOfDatas;
	private ValueAxis yAxis;

    public GraficaTemperaturaPanel(final String title) {
    	numberOfDatas = 10;
    	dataWindowSize = 10;
    	temperaturas = new XYSeries("Temperaturas");
        final JFreeChart chart = createChart();
        final ChartPanel chartPanel = new ChartPanel(chart, true, true, true, false, true);
        chartPanel.setPreferredSize(new Dimension(500, 400));
        add(chartPanel);
    }

    private JFreeChart createChart() {

    	
        final XYDataset data = initializeDataset();
        final XYItemRenderer renderer = new StandardXYItemRenderer();
        final NumberAxis rangeAxis = new NumberAxis("Degree Celsius");
        final XYPlot subplot = new XYPlot(data, null, rangeAxis, renderer);
        subplot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        
        final CombinedDomainXYPlot plot = new CombinedDomainXYPlot(new NumberAxis("Temperaturas"));
        plot.add(subplot, 1);
        plot.setOrientation(PlotOrientation.VERTICAL);

        ValueAxis range = subplot.getRangeAxis();
	    range.setRange(-50, 50);
	    
	    yAxis = subplot.getDomainAxis();
	    yAxis.setRange(0,numberOfDatas);
	    
        return new JFreeChart("Temperaturas Monitor",JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        

    }

    private XYDataset initializeDataset() {

    	for (int i = 0; i <= numberOfDatas; i++) {
    		temperaturas.add(i,0);
    	}
        final XYSeriesCollection collection = new XYSeriesCollection();
        collection.addSeries(temperaturas);
        return collection;

    }

	@Override
	public void manejarEvento(int temperaturaActual) {
		
		temperaturas.add(++numberOfDatas,temperaturaActual);
		yAxis.setRange(numberOfDatas-dataWindowSize, numberOfDatas);
	}

}