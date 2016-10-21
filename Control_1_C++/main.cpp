#include <iostream>
#include <iomanip>

using namespace std;

// my function to get bytesSum
int sum(int value1, int value2, int value3, int value4, int value5, int value6, int value7)
{
    return value1 + value2 + value3 + value4 + value5 + value6 + value7;
}

// INTITIALIZE IT WITH YOUR DATA!
enum week
{
    saturday = -755,
    sunday,
    monday,
    tuesday,
    wednesday = tuesday+2,
    thursday=-233,
    friday
} day;

struct name
{
    char ch;
    int k[3];
};

struct student
{
    union
    {
        float  a;
        double b;
    } max;
    char c;
    int b;
    name nm;
    char web [3][2];
    int i;
    week day;
}
        stud = {-225e-5,'Z',275,{'A',{60,61}},{'Z','B','C'},2100, friday}; // check it


int main()
{
    stud.max.b=125.125;     // check it
    stud.max.a=125;         // check it

    int bytesSum = sum(sizeof(stud.max), sizeof(stud.c), sizeof(stud.b), sizeof(stud.nm), sizeof(stud.web), sizeof(stud.i), sizeof(stud.day));

    // Task 1. RESULTS:
    cout << "Task 1. RESULTS: "<< endl;
    cout << "REAL Student size (consists form bytesSum + trash) = " << sizeof(stud) << " bytes"<<  endl;
    cout << "bytesSum (without additions to machine words) = " << bytesSum << " bytes"<<  endl;
    cout << "Trash (additions to complete machine words) = " << sizeof(stud) - bytesSum << " bytes"<<  endl <<  endl;       //additions to complete machine word, which is at least 4 Bytes

    // Struct 'max' consists from 2 variables, please check documentation about 'union'. So 'max' size has the same size as 'double', because 'double' is bigger than 'float'!
    cout << "stud.max (union) consists from 2 values. Size = "<< sizeof(stud.max) << endl;
    cout << "stud.max.a (float) = " << stud.max.a << ". Size = "<< sizeof(stud.max.a) << endl;
    cout << "stud.max.b (double) = " << stud.max.b << ". Size = "<< sizeof(stud.max.b) << endl << endl;

    cout << "stud.c (char) = " << stud.c << ". Size = "<< sizeof(stud.c) << endl;
    cout << "stud.b (int) = " << stud.b << ". Size = "<< sizeof(stud.b) << endl << endl;

    cout << "stud.nm (structure) consists from 4 values. Size = "<< sizeof(stud.nm) << endl;
    cout << "stud.nm.ch (char) = " << stud.nm.ch << ". Size = "<< sizeof(stud.nm.ch) << endl;
    cout << "stud.nm.k[0](int) = " << stud.nm.k[0] << ". Size = "<< sizeof(stud.nm.k[0]) << endl;
    cout << "stud.nm.k[1](int) = " << stud.nm.k[1] << ". Size = "<< sizeof(stud.nm.k[1]) << endl;
    cout << "stud.nm.k[2](int) = " << stud.nm.k[2] << ". Size = "<< sizeof(stud.nm.k[2]) << endl << endl;

    cout << "stud.web (2 dimension array) consists from 6 values. Size = "<< sizeof(stud.web) << endl;
    cout << "stud.web[0][0](char) = '" << stud.web[0][0] << "' Size = "<< sizeof(stud.web[0][0]) << endl;
    cout << "stud.web[0][1](char) = '" << stud.web[0][1] << "' Size = "<< sizeof(stud.web[0][1]) << endl;
    cout << "stud.web[1][0](char) = '" << stud.web[1][0] << "' Size = "<< sizeof(stud.web[1][0]) << endl;
    cout << "stud.web[1][1](char) = '" << stud.web[1][1] << "' Size = "<< sizeof(stud.web[1][1]) << endl;
    cout << "stud.web[2][0](char) = '" << stud.web[2][0] << "' Size = "<< sizeof(stud.web[2][0]) << endl;
    cout << "stud.web[2][1](char) = '" << stud.web[2][1] << "' Size = "<< sizeof(stud.web[2][1]) << endl << endl;

    cout << "stud.i (int) = " << stud.i << ". Size = "<< sizeof(stud.i) << endl;
    cout << "stud.day (enum) = " << stud.day << ". Size = "<< sizeof(stud.day) << endl << endl;

    // Task 2
    long b = -225;      // check it
    short  c = 25.5;    // check it
    short  d=25;        // change it

    int y = b * c - d+*(reinterpret_cast<short*> (&stud)+6); // check it

    cout << "Task 2:" << endl << "RESULT = " << y << endl;

    return 0;
}