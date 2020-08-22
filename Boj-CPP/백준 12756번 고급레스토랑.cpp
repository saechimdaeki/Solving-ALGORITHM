#include<iostream>
#include<algorithm>
#include<functional>
#include<vector>
using namespace std;

pair<int , int> a;
pair<int , int> b;
int main()
{
	cin>>a.first>>a.second;
	cin>>b.first>>b.second;
	while(true)
	{
		a.second-=b.first;
		b.second-=a.first;
		if(a.second<1 || b.second <1)
		break;
	}
	if ( a.second <1 && b.second<1)
	cout<<"DRAW"<<endl;
	else
	{
		cout<<"PLAYER ";
		if(a.second>b.second)
		cout<<"A";
		else
		cout<<"B";
	 } 
}
