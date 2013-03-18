
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PubSubTree {
	
	protected Long rootID;
	protected Map<Long, Node> tree;
	
	public PubSubTree(Map<Long, Node> t, Long root){
		tree = t;
		rootID = root.longValue();
	}
	
	void printTree(){
		System.out.println("++++++++++++++++++++++++TREE++++++++++++++++++++++++");
		for (Long key : tree.keySet()) {
		    System.out.println("Key = " + key);
		    Node nc = tree.get(key);
		    System.out.println("Link = " + nc.toString());
		}	
	}
	
	
	public ArrayList<NodePortTuple> buildRoute(long src, long dst){
		//Get labels of src and dst
		Long src_label = tree.get(src).getLabel();
		Long dst_label = tree.get(dst).getLabel();
		Long swID = (long)0;
		
		ArrayList<NodePortTuple> srcToDst = new ArrayList<NodePortTuple>();
		ArrayList<NodePortTuple> dstToSrc = new ArrayList<NodePortTuple>();
		
		//whichever is having higher label, move upwards till the label is same to the other
		if(src_label < dst_label){
			long label = dst_label;
			long srcID = tree.get(dst).getParent().getSrc();		
			
			while(label != src_label){
				long temp_srcID = tree.get(srcID).getParent().getSrc();
				short srcPort = tree.get(srcID).getParent().getSrcPort();	
				
				long temp_dstID = tree.get(srcID).getParent().getDst();
				short dstPort = tree.get(srcID).getParent().getDstPort();
				
				NodePortTuple<Long, Short> srcpair = new NodePortTuple<Long, Short>(temp_srcID, srcPort);
				NodePortTuple<Long, Short> dstpair = new NodePortTuple<Long, Short>(temp_dstID, dstPort);
				
				dstToSrc.add(srcpair);
				dstToSrc.add(dstpair);
				
				srcID = temp_dstID;
				label = tree.get(srcID).getLabel();
				
				if(label == src_label) swID = srcID;
				
			}
			
		}
		else if(src_label > dst_label){
			long label = src_label;
			long srcID = tree.get(src).getParent().getSrc();
			
			
			while(label != dst_label){
				long temp_srcID = tree.get(srcID).getParent().getSrc();
				short srcPort = tree.get(srcID).getParent().getSrcPort();	
				
				long temp_dstID = tree.get(srcID).getParent().getDst();
				short dstPort = tree.get(srcID).getParent().getDstPort();
				
				NodePortTuple<Long, Short> srcpair = new NodePortTuple<Long, Short>(temp_srcID, srcPort);
				NodePortTuple<Long, Short> dstpair = new NodePortTuple<Long, Short>(temp_dstID, dstPort);
				
				srcToDst.add(srcpair);
				srcToDst.add(dstpair);
				
				srcID = temp_dstID;
				label = tree.get(srcID).getLabel();
				
				if(label == dst_label)
					swID = srcID;
				
			}
		}
		
		//If the reached node is the required switch, we have the path
		//else move upwards both the nodes till we get the lowest common ancestor
		Long newSrc = src;
		Long newDst = dst;
		
		if(src_label > dst_label) 
			if ( swID == dst) return srcToDst;
			else {
				newSrc = swID;
			}
		
		//reverse and return the path
		else if (src_label < dst_label) 
			if (swID == src) {
				Collections.reverse(dstToSrc);
				return dstToSrc;
			}
			else {
				newDst = swID;
			}
		
		while(true){
			long src_temp_srcID = tree.get(newSrc).getParent().getSrc();
			long src_temp_dstID = tree.get(newSrc).getParent().getDst();
			short src_temp_srcPort = tree.get(newSrc).getParent().getSrcPort();
			short src_temp_dstPort = tree.get(newSrc).getParent().getDstPort();
			
			long dst_temp_srcID = tree.get(newDst).getParent().getSrc();
			long dst_temp_dstID = tree.get(newDst).getParent().getDst();
			short dst_temp_srcPort = tree.get(newDst).getParent().getSrcPort();
			short dst_temp_dstPort = tree.get(newDst).getParent().getDstPort();
			
			NodePortTuple<Long, Short> src_srcpair = new NodePortTuple<Long, Short>(src_temp_srcID, src_temp_srcPort);
			NodePortTuple<Long, Short> src_dstpair = new NodePortTuple<Long, Short>(src_temp_dstID, src_temp_dstPort);
			
			srcToDst.add(src_srcpair);
			srcToDst.add(src_dstpair);
			
			NodePortTuple<Long, Short> dst_srcpair = new NodePortTuple<Long, Short>(dst_temp_srcID, dst_temp_srcPort);
			NodePortTuple<Long, Short> dst_dstpair = new NodePortTuple<Long, Short>(dst_temp_dstID, dst_temp_dstPort);
			
			dstToSrc.add(dst_srcpair);
			dstToSrc.add(dst_dstpair);
			
			if(src_temp_dstID == dst_temp_dstID) break;
			
			newSrc =  src_temp_dstID;
			newDst =  dst_temp_srcID;
		}
		
		Collections.reverse(dstToSrc);
		srcToDst.addAll(dstToSrc);
		return srcToDst;
		
	}
	
	
}
