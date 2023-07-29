package tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Info
{
    ValueField[] values;
    public Info()
    {
	
    }
    
    public void readFile(String infoPath) throws IOException
    {
	//read the file at infoPath, put that in values
	//supports double, int, boolean, String types
	ArrayList<ValueField> valueList = new ArrayList<ValueField>();
	BufferedReader br = new BufferedReader(new FileReader(infoPath));
	String line = br.readLine();
	while (line != null)
	{	    
	    String[] input = line.split(" ");
	    Object value = null;
	    
	    if (input[0].equals("int"))
	    {
		value = Integer.parseInt(input[2]);
	    }
	    else if (input[0].equals("double"))
	    {
		value = Double.parseDouble(input[2]);
	    }
	    else if (input[0].equals("boolean"))
	    {
		value = Boolean.parseBoolean(input[2]);
	    }
	    else if (input[0].equals("String"))
	    {
		value = input[2];
	    }
	    
	    valueList.add(new ValueField(input[1], value));
	    line = br.readLine();
	}
	
	values = new ValueField[valueList.size()];
	for (int i = 0; i < values.length; i++)
	{
	    values[i] = valueList.get(i);
	}
	br.close();
    }
    
    public Object get(String fieldName)
    {
	for (ValueField value : values)
	{
	    if (value.getFieldName().equals(fieldName)) 
	    {
		return value.get();
	    }
	}
	return null;
    }
    
    public void set(String fieldName, Object newValue)
    {
	for (ValueField value : values)
	{
	    if (value.getFieldName().equals(fieldName)) value.set(newValue);
	}
    }
}
