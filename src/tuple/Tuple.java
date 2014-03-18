package tuple;

import java.util.HashMap;

public class Tuple {
	
	private HashMap<String, String> template;
	
	public Tuple(HashMap<String, String> template){
		this.template = template;
	}
	
	public Tuple(String valeur, String type){
		this.template = new HashMap<String, String>();	
		this.template.put(valeur, type);
	}
	
	public Tuple(){
		this.template = new HashMap<String, String>();
	}	

	public HashMap<String, String> getTemplate() {
		return template;
	}

	public void setTemplate(HashMap<String, String> template) {
		this.template = template;
	}
	
	public void addField(String valeur, String type){
		this.template.put(valeur, type);
	}
	
	public boolean equals(HashMap<String, String> tmpTemplate){
		if(this.template.equals(tmpTemplate)){
			return true;
		}
		return false;
	}

    public boolean isTemplate(HashMap<String, String> tmpTemplate){
        boolean ret = true;
        for(String s : tmpTemplate.values()){
            if(!template.containsValue(s)){
                ret = false;
            }
        }
        return ret;
    }
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.template.entrySet());
		result.append("\n");
		return result.toString();
	}
	
}
