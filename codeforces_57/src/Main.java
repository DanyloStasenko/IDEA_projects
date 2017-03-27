/*
    Task from:
    http://codeforces.com/problemset/problem/785/A?locale=en

    "Anton and Polyhedrons"

    Anton's favourite geometric figures are regular polyhedrons.
    Note that there are five kinds of regular polyhedrons:

     - Tetrahedron. Tetrahedron has 4 triangular faces.
     - Cube. Cube has 6 square faces.
     - Octahedron. Octahedron has 8 triangular faces.
     - Dodecahedron. Dodecahedron has 12 pentagonal faces.
     - Icosahedron. Icosahedron has 20 triangular faces.

    Anton has a collection of n polyhedrons.
    One day he decided to know, how many faces his polyhedrons have in total.
    Help Anton and find this number!

    Input
    The first line of the input contains a single integer n (1 ≤ n ≤ 200 000) — the number of polyhedrons in Anton's collection.

    Each of the following n lines of the input contains a string si — the name of the i-th polyhedron in Anton's collection.
    The string can look like this:

    "Tetrahedron" (without quotes), if the i-th polyhedron in Anton's collection is a tetrahedron.
    "Cube" (without quotes), if the i-th polyhedron in Anton's collection is a cube.
    "Octahedron" (without quotes), if the i-th polyhedron in Anton's collection is an octahedron.
    "Dodecahedron" (without quotes), if the i-th polyhedron in Anton's collection is a dodecahedron.
    "Icosahedron" (without quotes), if the i-th polyhedron in Anton's collection is an icosahedron.
    Output
    Output one number — the total number of faces in all the polyhedrons in Anton's collection.

    Examples
        input
            4
            Icosahedron
            Cube
            Tetrahedron
            Dodecahedron
        output
            42

        input
            3
            Dodecahedron
            Octahedron
            Octahedron
        output
            28

    Note
    In the first sample Anton has one icosahedron, one cube, one tetrahedron and one dodecahedron.
    Icosahedron has 20 faces, cube has 6 faces, tetrahedron has 4 faces and dodecahedron has 12 faces.
    In total, they have 20 + 6 + 4 + 12 = 42 faces.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int shapesCount = Integer.parseInt(reader.readLine());

        int result = 0;
        for (int i = 0; i < shapesCount; i++) {
            String currentShape = reader.readLine();
            if (currentShape.equals("Tetrahedron")){
                result += 4;
                continue;
            }

            if (currentShape.equals("Cube")){
                result += 6;
                continue;
            }

            if (currentShape.equals("Octahedron")){
                result += 8;
                continue;
            }

            if (currentShape.equals("Dodecahedron")){
                result += 12;
                continue;
            }

            if (currentShape.equals("Icosahedron")){
                result += 20;
            }
        }
        System.out.println(result);
    }
}
