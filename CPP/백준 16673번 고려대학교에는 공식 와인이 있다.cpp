#include<iostream>
#include<cmath>
using namespace std;



int main()
{
	int c,k,p;
	cin>>c>>k>>p;
	int koreauniv(0);
	for(int i=1; i<=c; i++)
		{
			koreauniv+=(k*i)+p*(i*i);
		}
		cout<<koreauniv;
	
}
