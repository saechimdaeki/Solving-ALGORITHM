#include<iostream>
#include<vector>
#include<string>
int arr[26];
using namespace std;
int main()
{
	int n;
	string bts;
	int aos(0);
	cin>>n;
	while(n--)
	{
		cin>>bts;
		arr[bts[0]-'a']++;
	}
	for(int i=0; i<26; i++)
	{
		if(arr[i]>=5)
		{
			cout<<i+'a';
			aos=1;
		}
		if(aos==0)
		cout<<"PREDAJA";
	}
}

