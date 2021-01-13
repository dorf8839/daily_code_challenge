package com.company;

public interface NodeList {

    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
//    void traverse(ListItem root);
    void traversePreOrder(ListItem root);
    void traverseInOrder(ListItem root);
    void traversePostOrder(ListItem root);

}
