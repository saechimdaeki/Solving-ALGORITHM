#include<iostream>
#include<algorithm>
using namespace std;
int n;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	if(n%8>=1 && n%8<=5)
	cout<<n%8;
	else if(n%8==6)
	cout<<"4";
	else if(n%8==0)
	cout<<"2";
	else if(n%8==7)
	cout<<"3";
}
