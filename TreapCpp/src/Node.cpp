#include "Node.h"
#include <stddef.h>

Node::Node(int info, double priority)
{
    this->info = info;
    this->priority = priority;
    left = NULL;
    right = NULL;
}

Node::~Node()
{

}
