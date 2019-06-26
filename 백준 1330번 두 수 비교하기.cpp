#include<iostream>
using namespace std;
int a,b;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>b;
	if(a<b)
	cout<<"<";
	else if(a>b)
	cout<<">";
	else
	cout<<"==";
}
