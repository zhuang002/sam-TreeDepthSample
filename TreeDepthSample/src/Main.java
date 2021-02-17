import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	static HashMap<Integer,ArrayList<Integer>> tree=new HashMap<>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadInput();
		System.out.println(1);
		// System.out.println(treeDepth(root));

	}

	private static int treeDepth(int parent) {
		// TODO Auto-generated method stub
		ArrayList<Integer> children=tree.get(parent);
		if (children.isEmpty()) {
			return 0;
		}
		int maxDepth=Integer.MIN_VALUE;
		for (int subNode:children) {
			int depth=treeDepth(subNode);
			if (maxDepth<depth) {
				maxDepth=depth;
			}
		}
		
		return maxDepth+1;
	}


	private static void ReadInput() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int lines=sc.nextInt();
		int nodes=sc.nextInt();
		
		
		for (int i=0;i<lines;i++) {
			int id1=sc.nextInt();
			int id2=sc.nextInt();
			if (!tree.containsKey(id1)) {
				tree.put(id1,new ArrayList<Integer>());
			} 
			ArrayList<Integer> children=tree.get(id1);
			children.add(id2);
			
		}
		
	}

}

