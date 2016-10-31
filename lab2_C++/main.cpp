#include <iostream>
#include <cstdio>

using namespace std;

int main() {
    /*
    ЗАВДАННЯ  НА  ЛАБОРАТОРНУ  РОБОТУ
    Завдання 1:
    Визначити, які неявні перетворення типів будуть відбуватись при обчисленнях.
    З’ясувати, чи відбудуться втрати значимості даних. Хід міркувань підтвердити програмними результатами.
    В звіти пояснити кожне перетворення і метод, яким воно здійснено.

    typedef      unsigned  int		    type_0;
    typedef      unsigned  short  int	type_1;
    typedef      unsigned  long  int	type_2;
    typedef      signed  short  int		type_3;
    typedef      signed  int		    type_4;
    typedef      signed  long  int		type_5;
    typedef      bool  			        type_6;
    typedef      char  			        type_7;
    typedef      wchar_t		    	type_8;
    typedef      float			        type_9;
    typedef      double  			    type_10;
    typedef      long double		    type_11;
    */

    unsigned  int           x0=0;		// замість  №  підставити значення:  DN % 9
    unsigned  short  int    x1=7;		// замість  №  підставити значення:  DN % DN --> DN = 7
    unsigned  long  int     x2=2;		// замість  №  підставити значення:  MN % 9
    unsigned  long  int     x3=3;		// замість  №  підставити значення:  MN % 13
    long  int               x4=4;		// замість  №  підставити значення: (DN * MN) % 9
    char                    x5=5;		// замість  №  підставити значення:  DN % 12
    unsigned  long  int     x6=6;		// замість  №  підставити значення:  MN % 3
    unsigned  long  int     x7=7;		// замість  №  підставити значення:  (DN * MN) % 12
    char                    x8=8;		// замість  №  підставити значення:  DN % 13
    unsigned  long  int     x9=9;		// замість  №  підставити значення:  MN % 6
    int                     x10=10;	    // замість  №  підставити значення:  (DN * MN) % 10
    int                     x11=11;	    // замість  №  підставити значення:  DN % 3

        // unsigned  short  int =  unsigned  short  int - 0xFFFFFFFA (hexadecimal FFFFFFFA)
        // unsigned  short  int = 7 - 0xFFFFFFFA */

    cout << "Task 1:"<< endl << endl;
    cout << "x1 = "<< x1 << endl;
    cout << "0xFFFFFFFA = " << 0xFFFFFFFA  << endl;
    x1 = x1 - 0xFFFFFFFA;
    cout << "after x1 changed = "<< x1 << endl << endl;




        // 2) unsigned  long  int = char + unsigned  int - unsigned  long  int
        //   unsigned  long  int = 'a' + 0 - 2*/

    int temp = 'a';
    cout << "x3 = "<< x3 << endl;
    cout << "x0 = "<< x0 << endl;
    cout << "x2 = "<< x2 << endl;
    cout << "a = "<< temp << endl;
    x3 = 'a' + x0 - x2;
    cout << "after x3 changed = "<< x3 << endl << endl;




        // 3) unsigned  long  int = long int + char + unsigned long int * 0.1
        //    unsigned  long  int = 4 + 5 + 6 * 0.1

    cout << "x7 = "<< x7 << endl;
    cout << "x4 = "<< x4 << endl;
    cout << "x5 = "<< x5 << endl;
    cout << "x6 = "<< x6 << endl;
    x7 = x4 + x5 + x6 * 0.1;
    cout << "after x7 changed = "<< x7 << endl << endl;





        // 4) char = unsigned  long  int + int  - int * 10
        //    char = 9 + 10 - 11*10

    cout << "x8 = "<< x8 << endl;
    cout << "x9 = "<< x9 << endl;
    cout << "x10 = "<< x10 << endl;
    cout << "x11 = "<< x11 << endl;
    x8 = x9 + x10 - x11*10;
    cout << "after x8 changed = "<< x8 << endl << endl;


    /*
    Завдання 2
    Визначити, які явні  і неявні перетворення типів будуть відбуватись.
    Результати обчислень підтвердити програмними результатами.
    В звіти пояснити кожне перетворення і кожний отриманий результат.

    // позначимо через DN і MN числа, що відповідають дню і місяцю народження,
    // через dn і mn – по дві цифри, що відповідають дню і місяцю народження,
    // наприклад:  DN=5 , MN=3 , dn=05 , mn =03
    // Стасенко Данило Володимирович (07.02.1996)
    // ==> DN = 7, MN = 2;  dn = 07, mn = 02

    const x_0=7*2*100;		    // наприклад:  5*3*100=1500  =>  x_0=1500;
    const x_1= 007020;	    	// наприклад:  x_1=005030;
    const x_2= 0x0702;		    // наприклад:  x_2=0x0503;
    const x_3= 002070;		    // наприклад:  x_3=003050;
    const x_4= 0x0207;	    	// наприклад:  x_4=0x0305;

    const y_0=7*2/100;		    // наприклад:  5*3/100=0.15  =>  y_0=0.15;
    const y_1= - 7.2;		    // наприклад:  y_1=-5.3;
    const y_2=   2.7e+2;		// наприклад:  y_2=3.5e+2;
    const y_3= - 7.2e1;		    // наприклад:  y_3=-5.3e1;
    const y_4= - 2.7e-1;		// наприклад:  y_4=-3.5e-1;
    */

    const double y_4 = -2.7e-1;		// наприклад:  y_4=-3.5e-1;*/


    int   x = 0x0702;			// замість  №  підставити значення:  DN % 5
    float y = y_4;			// замість  №  підставити значення:  DN % 3


    int   v2=*reinterpret_cast<char*> (&x) +1;
    int   v6=*(reinterpret_cast<char*> (&x)+2)+22;
    char  w0 =*(reinterpret_cast<char*>(&y)+2)+12;
    short w5=*(reinterpret_cast<short*>(&y)+2)+12;


    cout << "v6 = " << v6 << endl;
    cout << "w0 = " << w0 << endl;
    cout << "v2 = " << v2 << endl;
    cout << "w5 = " << w5 << endl;

    cout << "v2 - %d %x %c = \t";
    printf("%d %x %c    \n", v2,v2,v2);

    cout << "v6 - %d %x %c = \t";
    printf("%d %x %c    \n", v6,v6,v6);

    cout << "w0 - %x %u %d = \t";
    printf("%x %u %d    \n",w0,w0,w0);

    cout << "w5 - %x %u %d = \t";
    printf("%x %u %d    \n", w5,w5,w5);

    return 0;
}