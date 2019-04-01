#include<iostream>
#include<cmath>
using namespace std;
int N;
int eratos(int n)
{
	if(n==1)
	return 0;
	int bts=(int)sqrt(n);
	for(int i=2; i<=bts;i++)
	{
		if(n%i==0)
		return 0;
	}
	return 1;
}
void a_b(int n, int jari)
{
	if(jari==N)
		{
			cout<<n<<endl;
			return; 
		}
		for(int i=1; i<=9; i++)
		{
			if(eratos(n*10+i)==1) 
				a_b(n*10+i,jari+1);
				i++;
		}		
}
int main()
{
	cin>>N;
	for(int i=2; i<=10; i++)
	{
		if(eratos(i)==1)
		a_b(i,1);
	}
}
