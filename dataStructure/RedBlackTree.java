/**
* a red-black tree
*/

public class RedBlackTree{
	public RedBlackTreeNode root;
	public RedBlackTreeNode nil;
	private int rotateLeft(RedBlackTreeNode node){
		if(node != nil && node.right != nil){
			RedBlackTreeNode rnode = node.right;
			rnode.parent = node.parent;
			rnode.left.parent = node;
			node.right = rnode.left;
			RedBlackTreeNode pnode = node.right;
			if(pnode != nil){
				if(pnode.left == node)
					pnode.left = rnode;
				else
					pnode.right = rnode;
			}
			rnode.left = node;
			node.parent = rnode;
			return 0;
		}
		return -1;
	}
	private int rotateRight(RedBlackTreeNode node){
		if(node != nil && node.left != nil){
			RedBlackTreeNode lnode = node.left;
			lnode.parent = node.parent;
			lnode.right.parent = node;
			node.left = lnode.right;
			RedBlackTreeNode pnode = node.parent;
			if(pnode != nil){
				if(pnode.left == node)
					pnode.left = lnode;
				else
					pnode.right = lnode;
			}
			node.parent = lnode;
			lnode.right = node;
			return 0;
		}
		return -1;
	}
	public void insert(RedBlackTreeNode node){
		if(root == nil){
			root = node;
			node.left = nil;
			node.right = nil;
			node.color = 1;
		}
		RedBlackTreeNode tmp = root;
		int cont = 0;
		while(cont == 0){
			if(tmp.val <= node.val){
				if(tmp.left == nil){
					cont = 1;
				}else{
					tmp = tmp.left;
				}
			}else{
				if(tmp.right == nil){
					cont = 2;
				}else{
					tmp = tmp.right;
				}
			}
		}
		if(cont == 1){
			tmp.left = node;
			node.parent = tmp;
			node.left = nil;
			node.right = nil;
		}else{
			tmp.right = node;
			node.parent = tmp;
			node.left = nil;
			node.right = nil;
			node.color = 0;
		}
		if(tmp.color == 0)
			fixInsert(node);
	}
	private void fixInsert(RedBlackTreeNode node){
		while(node.parent.color == 0){
			if(node.parent.parent.left == node.parent){
				RedBlackTreeNode y = node.parent.parent.right;
				if(y.color == 0){	// then transit black from grandpa to dad and uncle 
					y.color = 1;
					node.parent.color = 1;
					node.parent.parent.color = 0;
					node = node.parent.parent;
				}else{
					if(node == node.parent.right){
						node = node.parent;
						rotateLeft(node);
					}
					node.parent.parent.color = 0;
					node.parent.color = 1;
					rotateRight(node.parent.parent);
				}
			}else{
				RedBlackTree y = node.parent.parent.left;
				if(y.color == 0){
					y.color = 1;
					node.parent.color = 1;
					node.parent.parent.color = 0;
					node = node.parent.parent;
				}else{
					if(node = node.parent.left){
						node = node.parent;
						rotateRight(node);
					}
					node.parent.parent.color = 1;
					node.parent = 0;
					rotateLeft(node.parent.parent);
				}
			}
		}
	}
	public void delete(RedBlackTreeNode node){
		RedBlackTreeNode y;
		if(node.left == nil || node.right == nil)
			y = node;
		else
			y = successor(node);
		RedBlackTreeNode x; // child of node-to-be-removed
		if(node.left != nil)
			x = node.left;
		else
			x = node.right;
		x.parent = y.parent;
		if(y.parent == nil)
			root = x;
		else{
			if(y.parent.left == y)
				y.parent.left = x;
			else
				y.parent.right = x;
		}
		if(y != node) 
			node.val = y.val;
		if(y.color == 1)
			fixDel(x);
	}
	private void fixDel(RedBlackTreeNode node){
		while(node.parent != nil && node.color == 1){
			if(node.parent.left == node){
				RedBlackTreeNode w = node.parent.right;	// sibling of node
				if(w.color == 0){
					node.parent.color = 0;
					w.color = 1;
					w = w.left;
					rotateLeft(node.parent);
				}
				if(w.left.color == 1 && w.right.color == 1){
					w.color = 0;
					node = node.parent;
				}else{
					if(w.left.color == 0){
						w.color = 0;
						w.left.color = 1;
						rotateRight(w);
						w = w.parent;
					}
					w.color = w.parent.color;
					w.parent.color = 1;
					w.right.color = 1;
					rotateLeft(w.parent);
					node = nil;
				}
			}else{
				RedBlackTreeNode w = node.parent.left;
				if(w.color == 0){
					w.color = 1;
					w.parent.color = 0;
					w = w.right;
					rotateRight(w.parent);
				}
				if(w.left.color == 1 && w.right.color == 1){
					w.color = 0;
					node = node.parent;
				}else{
					if(w.right.color == 0){
						w.right.color = 1;
						w.color = 0;
						rotateLeft(w);
						w = w.parent;
					}
					w.color = w.parent.color;
					w.left.color = 1;
					w.parent.color = 1;
					rotateRight(w.parent);
					node = nil;
				}
			}
		}
		node.color = black;
	}
	private RedBlackTreeNode successor(node){
		RedBlackTreeNode tmp = node.right;
		while(tmp.left != nil)
			tmp = tmp.left;
		return tmp;
	}
	public RedBlackTreeNode(){
		nil = new RedBlackTreeNode(0,1);
		this.root = nil;
	}
}