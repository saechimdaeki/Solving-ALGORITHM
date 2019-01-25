#include <iostream>
using namespace std;

int dynamic[11]; 
int dp(int a)
{
        dynamic[1] = 1; 
        dynamic[2] = 2; 
        dynamic[3] = 4; 
        for (int i = 4; i <= a; i++)
            dynamic[i] = dynamic[i - 1] + dynamic[i - 2] + dynamic[i - 3];
        return dynamic[a];
}
int main()
{
		int b;
        int n;
        cin >> n;
        for (int i = 0; i < n; i++)
        {
            cin >> b;
            cout << dp(b) << endl;
        }
        return 0;
}
