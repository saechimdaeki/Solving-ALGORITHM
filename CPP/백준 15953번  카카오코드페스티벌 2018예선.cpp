#include<iostream>
using namespace std;

int main()
{
	int a,b,t;
	cin>>t;
	for(int i=0; i<t; i++)
	{
		int gold(0);
		cin>>a>>b;
		if(a==1)
		gold+=5000000;
		else if(a>=2&&a<=3)
		gold+=3000000;
		else if(a>=4&&a<=6)
		gold+=2000000;
		else if(a>=7&&a<=10 )
		gold+=500000;
		else if(a>=11&&a<=15)
		gold+=300000;
		else if(a>=16&& a<=21)
		gold+=100000;
		if(b==1)
		gold+=5120000;
		else if(b>=2&& b<=3)
		gold+=2560000;
		else if(b>=4&&b<=7)
		gold+=1280000;
		else if(b>=8&&b<=15)
		gold+=640000;
		else if(b>=16 && b<=31)
		gold+=320000;
		cout<<gold<<endl;
	}
}
