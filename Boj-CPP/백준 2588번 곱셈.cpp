#include<iostream>
using namespace std;
int n1,n2;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n1>>n2;
	int mul(n1*n2);
	while(n2)
	{
		cout<<n2%10*n1<<"\n";
		n2/=10;
	}
	cout<<mul;
}
