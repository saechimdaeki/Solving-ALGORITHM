#include<iostream>
using namespace std;
int iam(5000);
int num;
int ans;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	while(cin>>num)
	{
		if(num==1)
		iam-=500;
		else if(num==2)
		iam-=800;
		else if(num==3)
		iam-=1000;
	}
	cout<<iam;
}
