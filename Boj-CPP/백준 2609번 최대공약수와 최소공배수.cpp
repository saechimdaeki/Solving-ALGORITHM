#include<iostream>
using namespace std;

int goong(int n1,int n2)
{
	if(n2==0)
	return n1;
	goong(n2,n1%n2);
}

int main()
{
	int n1,n2;
	cin>>n1>>n2;
	cout<<goong(n1,n2)<<endl;
	cout<<n1*n2/goong(n1,n2)<<endl;
}
