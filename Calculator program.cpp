#include <iostream>
using namespace std;

int main() {
    int a, b, c;
    char d;

    cout << "Name: AVINASH" << endl;
    cout << "REG.No: 2024503506" << endl;

    cout << "Enter two numbers:" << endl;
    cin >> a >> b;

    cout << "Enter the operation +, -, *, /: ";
    cin >> d;

    if (d == '+') {
        c = a + b;
        cout << "a + b = " << c << endl;
    } else if (d == '-') {
        c = a - b;
        cout << "a - b = " << c << endl;
    } else if (d == '*') {
        c = a * b;
        cout << "a * b = " << c << endl;
    } else if (d == '/') {
        if (b != 0) {
            c = a / b;
            cout << "a / b = " << c << endl;
        } else {
            cout << "Error: Division by zero" << endl;
        }
    } else {
        cout << "Wrong input" << endl;
    }

    return 0;
}
