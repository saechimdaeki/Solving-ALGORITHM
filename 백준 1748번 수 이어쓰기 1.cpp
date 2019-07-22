#include<iostream>
#include<algorithm>
using namespace std;
long long count123;
long long n;
int jari(int num)
{
	int a(0);
	while(num)
	{
		num/=10;
		a++;
	}
	return a;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=1; i<=n; i++)
		count123+=jari(i);
	
	cout<<count123;
}
