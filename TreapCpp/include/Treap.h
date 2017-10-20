#ifndef TREAP_H
#define TREAP_H
#include "Node.h"

class Treap
{
    public:
        double maxPriority;
        Node *root;
        void add(int info);
        Treap(double maxPriority);
        virtual ~Treap();
    protected:

    private:
        void addIn(int info, Node *node);
        void rotateRight(Node *node);
        void rotateLeft(Node *node);
};

#endif // TREAP_H
