import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class TestObj {
	protected Obj node;	// points to the root node
	
	public TestObj(){
		node = new Obj("*", null);
	}
	
	private void addNewNode(Obj node, Obj newEntry){
		//get the parent among the children
		Obj newNode = node;
		Obj parent = newNode;
		
		//ArrayList<Obj> children = new ArrayList<Obj>();
		//Iterator<Obj> itr = newNode.children.iterator();
		
		if(newNode.children.isEmpty()){
			//this is the only child
			newEntry.parent = parent;
			newNode.children.add(newEntry);
			return;
		}
		int count_lim = node.children.size();
		int count = 0;
		ArrayList<Integer> toberemoved = new ArrayList<Integer>();
		boolean isNewChild = false;
		
		while(count < count_lim){
			Obj temp = node.children.get(count);
			//See if it qualifies to be parent or child of the newEntry
			if(newEntry.dz.regionMatches(0, temp.dz, 0, temp.dz.length()-1)){
				//Either the new entry has the same dz or it is a child
				if(newEntry.dz.equals(temp.dz)){
					//Just add the new Entry at the same heirarchy
					newEntry.parent = parent;
					newNode.children.add(newEntry);
					return;
				}
				//It is a new child
				addNewNode(temp, newEntry);
				return;
			}
			else if(temp.dz.regionMatches(0, newEntry.dz, 0, newEntry.dz.length()-1)){
				//temp is a child of the new Entry
				isNewChild = true;
				temp.parent = newEntry;
				newEntry.children.add(temp);
				toberemoved.add(count);
				count++;
				continue;
			}
			count++;
		}
		
		if(isNewChild){
			newEntry.parent = parent;
			newNode.children.add(newEntry);
		}
		
		if((count == count_lim) && (newEntry.children.isEmpty())){
			newEntry.parent = parent;
			newNode.children.add(newEntry);
		}
		if((count == count_lim) && (!toberemoved.isEmpty())){
			Iterator<Integer> itr = toberemoved.iterator();
			int cnt = 0;
			while(itr.hasNext()){
				int idx = itr.next();
				newNode.children.remove(idx-cnt);
				cnt++;
			}
		}
		
		
	}
	
	public void addPubSub(String dz, boolean pubSub /*0 = pub, 1 = sub*/){
		Obj newNode = node;
		Obj newEntry = new Obj(dz, null);
		
		addNewNode(newNode, newEntry);
	}
	
	public void printTree(){
		print(node);
	}
	
	private void print(Obj node){
		ArrayList<Obj> children = new ArrayList<Obj>();
		Iterator<Obj> itr = node.children.iterator();
		
		System.out.println("dz :" + node.dz);
		System.out.println("Children : ");
		
		while(itr.hasNext()){
			print(itr.next());
		}
	}
}
