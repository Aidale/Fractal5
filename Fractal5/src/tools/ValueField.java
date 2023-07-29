package tools;

public class ValueField
{
    private String fieldName;
    private Object value;
    
    public ValueField(String fieldName, Object value)
    {
	this.fieldName = fieldName;
	this.value = value;
    }
    
    public void set(Object value)
    {
	this.value = value;
    }
    
    public String getFieldName()
    {
	return fieldName;
    }
    
    public Object get()
    {
	return value;
    }
}
