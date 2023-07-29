package fractal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import tools.Info;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Settings
{

    private JFrame frame;
    private JTextField scaleField;
    private JTextField centerXField;
    private JTextField centerYField;
    private JTextField iterationField;
    private JTextField rFactorField;
    private JTextField gFactorField;
    private JTextField bFactorField;
    private JTextField offsetField;
    private JLabel periodLabel;
    private JTextField periodField;
    private JButton genButton;

    public static void mainImage(Info info)
    {
	EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		try
		{
		    Settings window = new Settings(info);
		} 
		catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
	});
    }
    
    private Info info;
    private NumberFinder numberFinder;
    private FractalImage fractalImage;
    private Display display;
    public Settings(Info info)
    {
	this.info = info;
	numberFinder = new NumberFinder();
	display = new Display((int)info.get("WIDTH"), (int)info.get("HEIGHT"), numberFinder);
	generateNewFractal();
	initialize();
    }
    
    private void generateNewFractal()
    {
	fractalImage = new FractalImage(info);
	numberFinder.addFractal(fractalImage);
	display.setImage(fractalImage.getImage());
	display.repaint();
    }

    private void initialize()
    {
	frame = new JFrame();
	frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
	frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Aidan\\Pictures\\Settings-icon.png"));
	frame.setTitle("Settings");
	frame.setVisible(true);
	frame.setBounds(100, 100, 290, 621);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	Font tahoma = new Font("Tahoma", Font.PLAIN, 20);
	
	JLabel scaleLabel = new JLabel("Scale");
	scaleLabel.setFont(tahoma);
	scaleLabel.setBounds(28, 38, 84, 25);
	frame.getContentPane().add(scaleLabel);
	
	scaleField = new JTextField();
	scaleField.setFont(tahoma);
	scaleField.setBounds(129, 38, 110, 25);
	frame.getContentPane().add(scaleField);
	scaleField.setColumns(10);
	
	JLabel centerXLabel = new JLabel("Center X");
	centerXLabel.setFont(tahoma);
	centerXLabel.setBounds(28, 76, 101, 25);
	frame.getContentPane().add(centerXLabel);
	
	centerXField = new JTextField();
	centerXField.setFont(tahoma);
	centerXField.setBounds(129, 76, 110, 25);
	frame.getContentPane().add(centerXField);
	centerXField.setColumns(10);
	
	JLabel centerYLabel = new JLabel("Center Y");
	centerYLabel.setFont(tahoma);
	centerYLabel.setBounds(28, 113, 84, 25);
	frame.getContentPane().add(centerYLabel);
	
	centerYField = new JTextField();
	centerYField.setFont(tahoma);
	centerYField.setBounds(129, 113, 110, 25);
	frame.getContentPane().add(centerYField);
	centerYField.setColumns(10);
	
	JLabel iterationLabel = new JLabel("Iterations");
	iterationLabel.setFont(tahoma);
	iterationLabel.setBounds(28, 142, 96, 36);
	frame.getContentPane().add(iterationLabel);
	
	iterationField = new JTextField();
	iterationField.setFont(tahoma);
	iterationField.setBounds(129, 148, 110, 25);
	frame.getContentPane().add(iterationField);
	iterationField.setColumns(10);
	
	JLabel rFactorLabel = new JLabel("R Factor");
	rFactorLabel.setFont(tahoma);
	rFactorLabel.setBounds(28, 246, 96, 36);
	frame.getContentPane().add(rFactorLabel);
	
	rFactorField = new JTextField();
	rFactorField.setFont(tahoma);
	rFactorField.setBounds(129, 252, 110, 25);
	frame.getContentPane().add(rFactorField);
	rFactorField.setColumns(10);
	
	JLabel gFactorLabel = new JLabel("G Factor");
	gFactorLabel.setFont(tahoma);
	gFactorLabel.setBounds(28, 281, 96, 36);
	frame.getContentPane().add(gFactorLabel);
	
	gFactorField = new JTextField();
	gFactorField.setFont(tahoma);
	gFactorField.setBounds(129, 287, 110, 25);
	frame.getContentPane().add(gFactorField);
	gFactorField.setColumns(10);
	
	JLabel bFactorLabel = new JLabel("B Factor");
	bFactorLabel.setFont(tahoma);
	bFactorLabel.setBounds(28, 316, 96, 37);
	frame.getContentPane().add(bFactorLabel);
	
	bFactorField = new JTextField();
	bFactorField.setFont(tahoma);
	bFactorField.setBounds(129, 322, 110, 25);
	frame.getContentPane().add(bFactorField);
	bFactorField.setColumns(10);
	
	JLabel offsetLabel = new JLabel("Offset");
	offsetLabel.setFont(tahoma);
	offsetLabel.setBounds(28, 351, 73, 37);
	frame.getContentPane().add(offsetLabel);
	
	offsetField = new JTextField();
	offsetField.setFont(tahoma);
	offsetField.setBounds(129, 357, 110, 25);
	frame.getContentPane().add(offsetField);
	offsetField.setColumns(10);
	
	periodLabel = new JLabel("Period");
	periodLabel.setFont(tahoma);
	periodLabel.setBounds(28, 392, 84, 25);
	frame.getContentPane().add(periodLabel);
	
	periodField = new JTextField();
	periodField.setFont(tahoma);
	periodField.setBounds(129, 392, 110, 25);
	frame.getContentPane().add(periodField);
	periodField.setColumns(10);
	
	JCheckBox fillCheckBox = new JCheckBox("Fill Black");
	fillCheckBox.setFont(tahoma);
	fillCheckBox.setBounds(28, 443, 124, 21);
	frame.getContentPane().add(fillCheckBox);
	
	
	scaleField.setText(info.get("SCALE") + "");
	centerXField.setText(info.get("CENTER_X") + "");
	centerYField.setText(info.get("CENTER_Y") + "");
	iterationField.setText(info.get("MAX_ITERATION") + "");
	rFactorField.setText(info.get("R_FACTOR") + "");
	gFactorField.setText(info.get("G_FACTOR") + "");
	bFactorField.setText(info.get("B_FACTOR") + "");
	offsetField.setText(info.get("COLOR_OFFSET") + "");
	periodField.setText(info.get("COLOR_PERIOD") + "");
	fillCheckBox.setSelected((boolean)info.get("FILL_BLACK"));
	
	genButton = new JButton("Generate Fractal");
	genButton.addActionListener(new ActionListener() 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
		info.set("SCALE", Double.parseDouble(scaleField.getText()));
		info.set("CENTER_X", Double.parseDouble(centerXField.getText()));
		info.set("CENTER_Y", Double.parseDouble(centerYField.getText()));
		info.set("MAX_ITERATION", Integer.parseInt(iterationField.getText()));		
		info.set("R_FACTOR", Double.parseDouble(rFactorField.getText()));
		info.set("G_FACTOR", Double.parseDouble(gFactorField.getText()));
		info.set("B_FACTOR", Double.parseDouble(bFactorField.getText()));
		info.set("COLOR_OFFSET", Integer.parseInt(offsetField.getText()));
		info.set("COLOR_PERIOD", Integer.parseInt(periodField.getText()));
		info.set("FILL_BLACK", fillCheckBox.isSelected());
		generateNewFractal();
	    }
	});
	genButton.setFont(tahoma);
	genButton.setBounds(54, 497, 185, 36);
	frame.getContentPane().add(genButton);
    }
}