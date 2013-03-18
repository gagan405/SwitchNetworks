
public class NodePortTuple<Long, Short> {
	
	public final Long swId; 
	public final Short port; 
	public NodePortTuple(Long x, Short y) { 
	    this.swId = x; 
	    this.port = y; 
	} 
	
	@Override
	public String toString(){
		return "[ sw : " + this.swId + " port : " + this.port + " ]"; 
	}
	
}
