import java.util.ArrayList;


public class Node {
	Link parentLink;
	ArrayList<Link> childrenLink;
	Long label;
	
	public Node(Link p, ArrayList<Link> c, Long l){
		parentLink = p;
		childrenLink = c;
		label = l;
	}
	
	public Long getLabel(){
		return this.label;
	}
	
	public ArrayList<Link> getChildren(){
		return this.childrenLink;
	}
	
	public Link getParent(){
		return this.parentLink;
	}
	public void setChildren(ArrayList<Link> c){
		childrenLink = c;
	}
	
	@Override
	public String toString() {
        String s = "Label = " + this.label + parentLink.toString();
        if(childrenLink == null) return s;
        
        for(int i =0; i< childrenLink.size(); i++)
        	s += childrenLink.get(i).toString();
        
        return s;
    }
	
}
