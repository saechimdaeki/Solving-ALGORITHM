#include <iostream>
using namespace std;
int N;
void func(int bts, int blank)
{
        if (bts == -1)
                 return;
        for (int i = 0; i < bts; i++)
                 cout << " ";
        cout << "*";
        for (int i = 0; i < blank; i++)
                 cout << " ";
        cout << "*\n";
        func(bts - 1, blank + 2);
}
int main()
{
        cin >> N;
        if (N % 2 == 0)
            cout << "I LOVE CBNU\n";
        else
        {
            for (int i = 0; i < N; i++)
                cout << "*";
                cout << "\n";
                int mid = N / 2;
                for (int i = 0; i < mid; i++)
                    cout << " ";
                cout << "*\n";
                 func(mid - 1, 1);
        }
        return 0;
}
