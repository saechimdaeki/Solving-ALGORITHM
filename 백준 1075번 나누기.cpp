#include<iostream>
using namespace std;

int main()
{
	int n,f;
	cin>>n>>f;
	int bts=(n/100)*100;
	int abc;
	for(int i=bts; i<bts+100; i++)
	{
		if(i%f==0)
		{
			abc=i%100;
			break;
		}
	}
	if(abc<10)
	cout<<"0";
	cout<<abc<<"\n";
}
