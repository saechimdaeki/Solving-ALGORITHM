#include<iostream>
#include<algorithm>
using namespace std;
int count123;
int a,b,c,d;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>b>>c>>d;
	int n;
	cin>>n;
	while (true)
    {
        if (a % 10 == n || a / 10 == n || b % 10 == n || b / 10 == n )
        count123++;
        if (a == c && b == d)
            break;
        b++;
        if (b == 60)
        {
            b = 0;
            a++;
        }
    }
    cout << count123 << endl;
}
