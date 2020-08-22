#include<iostream> 
using namespace std;


int superjunior(int n)
{
	int a=n%10;
	int b=(n/10)%10;
	int c=(n/100)%10;
	
	int rogguga=c+b*10+a*100;
	return rogguga;
}

int main()
{
	int n1(0),n2(0);
	cin>>n1>>n2;
	
	if(superjunior(n1)>superjunior(n2))
		cout<<superjunior(n1);
		else
		cout<<superjunior(n2);
	
	
	
	
}
