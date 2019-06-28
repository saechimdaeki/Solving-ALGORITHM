#include<iostream>
#include<algorithm>
using namespace std;

int t;
long long n;

long long get(long long num)
{
	long long count123(0);
	while(num !=0)
	{
		num/=10;
		count123++;
	}
	return count123;
 } 
 
 long long get2(long long num, long long num2)
 {
 	long long pointer(0);
 	for(int i=0; i<num2; i++)
 	{
 		pointer*=10;
 		pointer+=9;
	 }
	 return (pointer-num)*num;
 }
 int pow_(long long num)
 {
 	long long pointer(1);
 	for(int i=0; i<num; i++)
 	pointer*=10;
 	return pointer;
 }
 int main()
 {
 	ios::sync_with_stdio(false);
 	cin.tie(NULL);
 	cin>>t;
 	for(int i=0; i<t; i++)
 	{
 		cin>>n;
 		long long a(get(n));
 		long long b(pow_(a-1));
 		long long c=b*10/2;
 		if(n>=c)
 		cout<<get2(c,a)<<"\n";
 		else
 		cout<<get2(n,a)<<"\n";
	 }
 }
