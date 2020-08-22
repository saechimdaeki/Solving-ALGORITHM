#include<iostream>

using namespace std;
void swap(long long &n1 ,long long &n2)
{
	long long tmp=n1;
	n1=n2;
	n2=tmp;
}
int main()
{
	long long a,b;
	cin>>a>>b;
	if(a>b)
	swap(a,b);
	 if(a!=b)
	{
		cout<<b-a-1<<endl;
		for(long long i= a+1; i<b; i++)
			cout<<i<<" ";
			cout<<endl;
	}
	else
	cout<<0<<endl;
}
