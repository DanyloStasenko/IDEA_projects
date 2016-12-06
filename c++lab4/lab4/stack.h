#ifndef STACK_H
#define STACK_H
 
#include <cassert>      // for assert
#include <iostream>
 
#include <iomanip>      // for setw
using namespace std;

template <typename T>
class Stack
{
private:
    T *stackPtr;                                // pointer
    const int size;                             // max stack capacity
    int top;                                    // current top value
    bool full;                                  // full
public:
    Stack(int = 5);                             // default stack size = 5
    Stack(const Stack<T> &);                    // copying constructor
    ~Stack();                                   // destructor
 
    inline void push(const T & );               // set element to the top
    inline T pop();                             // delete and return top element
    inline void printStack();                   // show stack
    inline const T &Peek(int ) const;           // n (-th) element in the queue
    inline int getStackSize() const;            // get stack size
    inline T *getPtr() const;                   // get pointer
    inline int getTop() const;                  // get current top number
    inline bool isFull() const;                 // check for full
    inline bool isReflected() const;            // check for reflection
};


template <typename T>
Stack<T>::Stack(int maxSize) : size(maxSize)    // constructor

{
    stackPtr = new T[size];
    top = 0;
    full = false;
}


template <typename T>                                             // copying constructor
Stack<T>::Stack(const Stack<T> & otherStack) : size(otherStack.getStackSize())

{
    stackPtr = new T[size];
    top = otherStack.getTop();
    full = otherStack.full;
 
    for(int i = 0; i < top; i++)
        stackPtr[i] = otherStack.getPtr()[i];
}
 

template <typename T>
Stack<T>::~Stack()                              // destructor
{
    delete [] stackPtr;
}
 

template <typename T>
inline void Stack<T>::push(const T &value)      // add element
{
    assert(!full);
    cout << "Pushing " << value << endl;

    stackPtr[top++] = value;

    if (top == size)
    {
        full = true;
        cout << "Warning! Stack is full now" << endl;
    }
    printStack();
}
 

template <typename T>
inline T Stack<T>::pop()                        // delete from stack
{
    assert(top > 0);
    cout << "Deleting " << stackPtr[--top] << endl;

    if (isFull())
    {
        full = false;
        cout << "Now stack is not full" << endl;
    }
    printStack();
}


template <class T>
inline const T &Stack<T>::Peek(int position) const      // get N(-th) element in the queue
{
  //
  assert(position <= top+1);
 
  return stackPtr[top - position];
}


template <typename T>
inline void Stack<T>::printStack()               // print stack
{
    cout << "Printing stack: " << endl;
    for (int i = top - 1; i >= 0; i--)
        cout << "|" << setw(4) << stackPtr[i] << endl;
}


template <typename T>
inline int Stack<T>::getStackSize() const       // get stack capacity
{
    return size;
}
 

template <typename T>
inline T *Stack<T>::getPtr() const              // get stack ptr (for copying)
{
    return stackPtr;
}


template <typename T>
inline int Stack<T>::getTop() const             // get top element
{
    return top;
}


template <typename T>                           // check for full
inline bool Stack<T>::isFull() const
{
    return full;
}


template <typename T>
inline bool Stack<T>::isReflected() const       // check for reflection
{
    bool reflected = true;
    for(int i = 1; i <= size; i++)
    {
        //cout << Stack<T>::Peek(i) << "    " << Stack<T>::Peek(getTop()-i+1) << endl ;
        if (Stack<T>::Peek(i) != Stack<T>::Peek(getTop()-i+1))
        {
            reflected = false;
            break;
        }
    }
    return reflected;
}
#endif // STACK_H