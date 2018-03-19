package suis4j.profile;

import java.util.List;

/**
*Class Message.java
*@author Ziheng Sun
*@time Jan 31, 2018 12:03:16 PM
*/
public class Message {
	
	List<Parameter> parameter_list;
	
	String error;
	
	/**
	 * This constructor is protected. 
	 * It is recommended to use MessageBuilder to create a new Message object.
	 */
	protected Message(){}
	
	public Message value(String parameter, String value){
		
		Parameter p = this.get(parameter);
		
		p.setValue(value);
		
		return this;
		
	}
	
	public Message value(String parameter, double value){
		
		Parameter p = this.get(parameter);
		
		p.setValue(value);
		
		return this;
		
	}
	
	public Message value(String parameter, int value){
		
		Parameter p = this.get(parameter);
		
		p.setValue(value);
		
		return this;
		
	}
	
	public Message value(String parameter, boolean value){
		
		Parameter p = this.get(parameter);
		
		p.setValue(value);
		
		return this;
		
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Parameter get(String name, String namespace){
		
		Parameter p = null;
		
		for(int i=0;i<parameter_list.size();i++){
			
			if(name.equals(parameter_list.get(i).getName()) 
					&& namespace.equals(parameter_list.get(i).getNamespace())){
				
				p = parameter_list.get(i);
				
				break;
				
			}
			
		}
		
		if(p==null){
			
			throw new RuntimeException("Fail to find parameter with name: " + name);
			
		}
		
		return p;
	}
	
	public Parameter get(String name){
		
		Parameter p = null;
		
		int pidx = -1;
		
		for(int i=0;i<parameter_list.size();i++){
			
			if(name.equals(parameter_list.get(i).getName())){
				
				p = parameter_list.get(i);
				
				pidx = i;
				
				break;
				
			}
			
		}
		
//		if(pidx==-1){
//			
//			throw new RuntimeException("Fail to find parameter with name: " + name);
//			
//		}
		
		return p;
	}

	public List<Parameter> getParameter_list() {
		return parameter_list;
	}

	public void setParameter_list(List<Parameter> parameter_list) {
		this.parameter_list = parameter_list;
	}
	
	public static class Builder {

		Message m;
		
		public Builder(){
			
			m = new Message();
			
		}
		
		public Message.Builder params(List<Parameter> paramlist){
			
			m.setParameter_list(paramlist);
			
			return this;
			
		}
		
		public Message.Builder error(String error){
			
			m.setError(error);
			
			return this;
			
		}
		
		public Message build(){
			
			return m;
			
		}
		
	}
	
}
