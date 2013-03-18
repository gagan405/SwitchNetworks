import java.util.List;
import java.util.ArrayList;
//import java.lang.Number;

public class Obj {
	
	protected String dz;
	protected int pCount;
	protected int sCount;
	
	protected ArrayList<Obj> children;
	Obj parent;
	
	public Obj(String dz, Obj p){
		this.dz = dz;
		children = new ArrayList<Obj>();
		parent = p;
		pCount = 0;
		sCount = 0;
	}
	
	public void setChildren(ArrayList<Obj> children){
		this.children = children;
	}
	
	public Obj getParent(){
		return this.parent;
	}
	
	
}
