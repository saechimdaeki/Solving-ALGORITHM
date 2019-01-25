#include<iostream>
#include<cstring> 
using namespace std;

int main()
{
	int num;//¼ýÀÚ °¹¼ö 
	cin>>num;
	char abcd;
	int sum(0);
	for(int i=0; i<num; i++)
	{
		cin>>abcd;
		sum+=(abcd-'0');
	}
	cout<<sum<<endl;
	
	
} 
