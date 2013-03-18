import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class Test {
	
	protected static Map<Long, Set<Link>> swlinks;
	protected static Map<Long, Set<Link>> graph;
	//protected static Map<Long, ArrayList<Link>> tree;
	protected static Map<Long, Long> labels;
	//protected static Map<Long, Node> tree;
	protected static Map<Long, PubSubTree> treeList;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		String s ="001*";
		String pattern = "0*";
		if(s.regionMatches(0, pattern, 0, pattern.length()-1)) System.out.println(s + "matches" + pattern);
		
		//if(s.matches(pattern)) System.out.println(s + "matches" + pattern);
		//if(pattern.matches(s)) System.out.println(pattern + "matches" + s);
		
		
		TestObj t = new TestObj();
		t.addPubSub("001*", true);
		t.addPubSub("1*", true);
		t.addPubSub("01*", false);
		t.addPubSub("0011*", true);
		t.addPubSub("1001*", true);
		t.addPubSub("100*", true);
		t.addPubSub("00101*", true);
		t.addPubSub("00100*", true);
		t.addPubSub("0101*", true);
		t.addPubSub("1000*", true);
		t.addPubSub("0*", true);
		t.printTree();
*/
		
		Set<Link> temp = new HashSet<Link>();
		Set<Link> temp4 = new HashSet<Link>();
		Set<Link> temp3 = new HashSet<Link>();
		Set<Link> temp5 = new HashSet<Link>();
		Set<Link> temp8 = new HashSet<Link>();
		Set<Link> temp7 = new HashSet<Link>();
		
		Link new_link = new Link(1, 1, 2 , 2);
		temp.add(new_link);
		
		Link new_link14 = new Link(1, 5, 4 , 5);
		temp.add(new_link14);
		
		Link new_link41 = new Link(4, 5, 1 , 5);
		temp.add(new_link41);
		
		Link new_link1 = new Link(2, 2, 1 , 1);
		temp.add(new_link1);
		
		swlinks = new HashMap<Long, Set<Link>>();
		swlinks.put((long) 1, temp);
		

		Link new_link2 = new Link(2, 1, 3 , 2);
		temp.add(new_link2);
		temp3.add(new_link2);

		Link new_link3 = new Link(3, 2, 2 , 1);
		temp.add(new_link3);
		temp3.add(new_link3);

		Link new_link4 = new Link(2, 3, 4 , 3);
		temp.add(new_link4);
		temp4.add(new_link4);

		Link new_link5 = new Link(4, 3, 2 , 3);
		temp.add(new_link5);
		temp4.add(new_link5);
		temp4.add(new_link14);
		temp4.add(new_link41);
		
		Link new_link45 = new Link(4, 2, 5 , 1);
		Link new_link54 = new Link(5, 1, 4 , 2);
		temp4.add(new_link45);
		temp4.add(new_link54);
		temp5.add(new_link45);
		temp5.add(new_link54);
		
		
		
		Link new_link48 = new Link(4, 1, 8 , 2);
		Link new_link84 = new Link(8, 2, 4 , 1);
		temp4.add(new_link48);
		temp4.add(new_link84);
		temp8.add(new_link48);
		temp8.add(new_link84);
		
		Link new_link35 = new Link(3, 6, 5 , 6);
		Link new_link53 = new Link(5, 6, 3 , 6);
		temp5.add(new_link35);
		temp5.add(new_link53);
		temp3.add(new_link35);
		temp3.add(new_link53);
		
		Link new_link37 = new Link(3, 8, 7 , 1);
		Link new_link73 = new Link(7, 1, 3 , 8);
		temp3.add(new_link37);
		temp3.add(new_link73);
		temp7.add(new_link37);
		temp7.add(new_link73);
		
		
		
		
		swlinks.put((long) 2, temp);
		swlinks.put((long) 3, temp3);
		swlinks.put((long) 4, temp4);
		swlinks.put((long) 5, temp5);
		swlinks.put((long) 7, temp7);
		swlinks.put((long) 8, temp8);
		
		
		buildGraph();
		printGraph();
		
		buildTree(2,0);
		
//		tree.clear();
		
		buildTree(1,1);
		
//		tree.clear();
		
		buildTree(4,2);
		
//		tree.clear();

		buildTree(3,3);
		
//		tree.clear();
		

		buildTree(7,4);
		
//		tree.clear();
		

		buildTree(5,5);
		
//		tree.clear();
		

		buildTree(8,6);
		
		printTree(0);
		printTree(1);
		printTree(2);
		printTree(3);
		printTree(4);
		printTree(5);
		printTree(6);
		
		System.out.println("*****************" + treeList.size());
		
		//This does not work !!
		PubSubTree tree = treeList.get(2l);
		if(tree == null) System.out.println("NULL");
		
		//ArrayList<NodePortTuple> route1 = new ArrayList<NodePortTuple>();
		//route1 = tree.buildRoute(8,7);
		//printRoute(route1);
		
		//ArrayList<NodePortTuple> route2 = treeList.get(4).buildRoute(8,7);
		//printRoute(route2);
		
		
		
		//The Following works
		printRoute(2);
		
		//PubSubTree tree = treeList.get(2);
		//tree.printTree();
		
		
		
	}
	
	public static void printRoute(long dz){
		PubSubTree tree = treeList.get(dz);
		if(tree == null) System.out.println("NULL");
		ArrayList<NodePortTuple> r = tree.buildRoute(8,7);
		for (int i = 0; i < r.size(); i++)
			System.out.println(r.get(i).toString());
	}
	
	
	public static void printTree(long i){
		PubSubTree tree = treeList.get(i);
		tree.printTree();
	}
	
	public static void buildGraph(){
		//Graph as an adjacency list
		//Map between Switch IDs and Set of links attached to the switch
		//Links are put in the set only where the switch is the source
		//This removes repeating the links twice
		
		if(graph == null) graph = new HashMap<Long, Set<Link>>();
		
		for(Long key : swlinks.keySet()){
			Set<Link> l = swlinks.get(key);
			Set<Link> temp = new HashSet<Link>();
			
			for(Link li : l){
				if(li.getSrc() == key){
					Link new_link = new Link(li.getSrc(), li.getSrcPort(), li.getDst(), li.getDstPort());
					temp.add(new_link);
				}
			}
			graph.put(key, temp);
		}	
		
	}
	
	public static void printGraph(){
		System.out.println("++++++++++++++++++++++++GRAPH++++++++++++++++++++++++");
		for (Long key : graph.keySet()) {
		    System.out.println("Key = " + key);
		    System.out.println(graph.get(key).toString());
		}
	}
	
	
	public static void buildTree(long root, long dz){
		//breadth first search from the root switch
		if(treeList == null) treeList = new HashMap<Long, PubSubTree>();
		
		Map<Long, Node> temp = new HashMap<Long, Node>();
		
		long swid = root;
		//Set<Link> l = graph.get(root);
		Link n = new Link(-1, -1, -1, -1);
		
		Node no = new Node(n, null,(long) 0);
		
		temp.put(swid, no);
		
		Queue<Long> q = new LinkedList<Long>();
		q.add(swid);
		
		while(!q.isEmpty()){
			long sw = q.poll();
			ArrayList<Link> linkArr = new ArrayList<Link>();
			
			
			for(Link li : graph.get(sw)){
				long childNode = li.getDst();
				
				if(!temp.containsKey(childNode)){
					
					Link parentLink = new Link(li.getDst(), li.getDstPort(), li.getSrc(), li.getSrcPort());
					Node nc = new Node(parentLink, null, temp.get(sw).getLabel()+1 );
					linkArr.add(li);
					
					temp.put(childNode, nc);
					q.add(childNode);
				}			
			}
			if(!linkArr.isEmpty()){
				Node t = temp.get(sw);
				t.setChildren(linkArr);
				temp.put(sw, t);
			}
			
		}
		
		PubSubTree tree = new PubSubTree(temp, root);
		treeList.put(dz, tree);
	}


	
/*	public static ArrayList<NodePortTuple> buildRoute(long src, long dst){
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
*/	
}
