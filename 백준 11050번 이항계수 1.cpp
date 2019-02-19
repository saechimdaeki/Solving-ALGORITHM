#include<iostream>
using namespace std;


int e_hang(int n)
{
	if(n==1 ||n==0)
	return 1;
	
	return e_hang(n-1)*n;
 } 


int main()
{
	int n,k;
	cin>>n>>k;
	cout<<e_hang(n)/(e_hang(k)*e_hang(n-k));
	
}
