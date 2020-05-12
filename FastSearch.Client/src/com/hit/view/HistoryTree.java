package com.hit.view;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class HistoryTree extends JTree {
	private String name;
	private java.net.URL url;
	JList bookmark;
	boolean isvalid = false;
	MainView mainView;

	public HistoryTree(DefaultMutableTreeNode node) {
		super(node);
		this.clearSelection();
	}
	public JList getBookmark() {
		return bookmark;
	}
	public void setBookmark(JList bookmark) {
		this.bookmark = bookmark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.net.URL getUrl() {
		return url;
	}
	public void setUrl(java.net.URL url) {
		this.url = url;
	}


	public void addToHistory(String nodeToAdd) {
		DefaultMutableTreeNode root1 = (DefaultMutableTreeNode)this.getModel().getRoot();
		int count = this.getModel().getChildCount(root1)+1;
		if (count == 14) {

			JOptionPane.showMessageDialog(mainView, "BookMark is full!");
		}
		else {
			DefaultTreeModel model = (DefaultTreeModel) this.getModel();
			DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.getModel().getRoot();
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(nodeToAdd);
			model.insertNodeInto(child, root, root.getChildCount());
			this.scrollPathToVisible(new TreePath(child.getPath()));
		}
	}

	public void Delete() {
		DefaultMutableTreeNode node;
		DefaultTreeModel model = (DefaultTreeModel) (this.getModel());
		TreePath[] paths = this.getSelectionPaths();
		if (paths==null)
		{
			JOptionPane.showMessageDialog(mainView, "You must choose a node to delete!");
		}
		else
		{
			for (int i = 0; i < paths.length; i++) {
				node = (DefaultMutableTreeNode) (paths[i].getLastPathComponent());
				model.removeNodeFromParent(node);
			}

		}
	}

	public void DeleteAll()
	{
		DefaultTreeModel model = (DefaultTreeModel) this.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		root.removeAllChildren();
		model.reload();
	}
    
}
    





