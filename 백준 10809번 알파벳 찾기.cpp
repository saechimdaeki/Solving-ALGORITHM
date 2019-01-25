#include<iostream>
#include<cstring>
using namespace std;
char arr[100];
int alpha[26];
int main()
{
	cin>>arr;
	int a=strlen(arr);
	for(int i=0; i<26;i++)
	alpha[i]=-1;
	
	for(int i=0; i<a; i++)
	{
		if(alpha[arr[i]-'a']>=0)
		continue;
		alpha[arr[i]-'a']=i;
	}
	for(int i=0; i<=('z'-'a'); i++)
	{
		printf("%d ",arr[i]);
	}
	
}
