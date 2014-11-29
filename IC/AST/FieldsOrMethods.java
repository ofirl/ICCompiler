package IC.AST;

import java.util.LinkedList;
import java.util.List;

public class FieldsOrMethods {
	private List<Field> fields;
	private List<Method> methods;
	
	public FieldsOrMethods() {
		fields = new LinkedList<Field>();
		methods = new LinkedList<Method>();
	}
	
	public void add(Field f) {
		fields.add(f);
	}
	
	public void add(List<Field> lst) {
		fields.addAll(lst);
	}
	
	public void add(Method m) {
		methods.add(m);
	}
	
	public List<Field> getFields() {
		return fields;
	}
	
	public List<Method> getMethods() {
		return methods;
	}
}
