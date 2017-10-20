#ifndef NODE_H
#define NODE_H


class Node
{
    public:
        int info;
        double priority;
        Node* right;
        Node* left;
        Node(int info, double priority);
        virtual ~Node();
    protected:

    private:
};

#endif // NODE_H
