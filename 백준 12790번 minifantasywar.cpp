#include<iostream>
#include<algorithm>
using namespace std;

int t;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	for(int i=0; i<t; i++)
	{
		int hp,mp,attack,defend,a1,a2,a3,a4;
		cin>>hp>>mp>>attack>>defend>>a1>>a2>>a3>>a4;
		hp+=a1; mp+=a2;
		attack+=a3; defend+=a4;
		if(hp<1)
		hp=1;
		if(mp<1)
		mp=1;
		if(attack<1)
		attack=0;
		cout<<1*hp+5*mp+2*attack+2*defend<<"\n"; 
	}
}
