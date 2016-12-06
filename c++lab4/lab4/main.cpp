/* Виконав студент групи КІ-21 Стасенко Д.В.
 *
 * Варіант - 6:
 *
 * Реалізувати стек, у якому до опису стека додано логічну змінну FULL,
 * що приймає значення true, якщо стек повний, і значення false, якщо це не так.
 * Переписати основні функції  роботи зі стеком з врахуванням цієї змінної.
 * Після обробки заданої вхідної послідовності перевірити, чи  стек буде “дзеркальним”
 * (тобто перший елемент буде дорівнювати останньому, другий – передостанньому і т.д.).
*/

#include <stack>
#include <iostream>
#include "stack.h"

using namespace std;

int main()
{
    Stack<int> intStack(5);

    // fill stack
    int value;
    while ( !intStack.isFull())
    {
        cin >> value;

        if(value %2 == 1)
        {
            intStack.pop();
            continue;
        }

        intStack.push(value);
    }
    cout << endl;

    if (intStack.isReflected())
    {
        cout <<"Stack is reflected" << endl;
    }
    else
    {
        cout <<"Stack is NOT reflected" << endl;
    }

    return 0;
}