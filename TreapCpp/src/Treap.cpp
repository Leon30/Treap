#include "Treap.h"
#include <stddef.h>
#include <iostream>
#include <cstdlib>

Treap::Treap(double maxPriority){
    root = NULL;
    this->maxPriority = maxPriority;
}

Treap::~Treap(){
    delete root;
}

void Treap::add(int info){
    if(this->root == NULL){
        root = new Node(info, rand() * maxPriority);
    }else{
        addIn(info, root);
    }
}

void Treap::addIn(int info, Node *node){
    if(info > node->info){
        if(node->left != NULL) addIn(info, node->left);
			else node->left = new Node(info, rand() * maxPriority);

			if(node->left->priority < node->priority){
				rotateRight(node);
			}
    }else{
        if(node->right != NULL) addIn(info, node->right);
			else node->right = new Node(info, rand() * maxPriority);

			if(node->right->priority > node->priority){
				rotateLeft(node);
			}
    }
}

void Treap::rotateLeft(Node *node){
    Node *aux = node->right;
    Node *auxLeft = node->left;

    aux->left = aux;
    node->right = auxLeft;

    *node = *aux;
}

void Treap::rotateRight(Node *node){
    Node *aux = node->left;
    Node *auxRight = node->right;

    aux->right = aux;
    node->left = auxRight;

    *node = *aux;
}
