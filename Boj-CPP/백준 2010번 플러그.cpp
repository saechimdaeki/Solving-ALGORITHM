#include<iostream>
using namespace std;

 int multi[500000];
int n;


int main()
{
	
	
	
	cin>>n;
	for(int i=0; i<n; i++)
	cin>>multi[i];
	int bts=multi[0];
	for(int i=1; i<n; i++)
	{
		bts-=1;
		bts+=multi[i];
	}
	cout<<bts<<endl;
}
