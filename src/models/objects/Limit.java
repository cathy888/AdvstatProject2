package models.objects;

public class Limit {
	
	private boolean enabled;
	private double value;
	
	public Limit() {
		enabled = false;
		value = 0;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
}
