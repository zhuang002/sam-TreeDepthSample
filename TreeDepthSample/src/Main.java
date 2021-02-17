import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	static Node tree;
	static Node[] nodeArray=null;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadInput();
		System.out.println(treeDepth(nodeArray[1]));
		// System.out.println(treeDepth(root));

	}

	private static int treeDepth(Node parent) {
		// TODO Auto-generated method stub
		
		if (parent.children.isEmpty()) {
			return 0;
		}
		int maxDepth=Integer.MIN_VALUE;
		for (Node subNode:parent.children) {
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
		nodeArray=new Node[nodes+1];
		for (int i=0;i<nodeArray.length;i++) {
			nodeArray[i]=null;
		}
		
		for (int i=0;i<lines;i++) {
			int id1=sc.nextInt();
			int id2=sc.nextInt();
			Node n1,n2;
			if (nodeArray[id1]==null) {
				n1=new Node();
				n1.id=id1;
				nodeArray[id1]=n1;
			} else {
				n1=nodeArray[id1];
			}
			if (nodeArray[id2]==null) {
				n2=new Node();
				n2.id=id2;
				nodeArray[id2]=n2;
			} else {
				n2=nodeArray[id2];
			}
			n1.children.add(n2);	
		}
		
	}

}


class Node {
	int id;
	ArrayList<Node> children=new ArrayList<>();
}