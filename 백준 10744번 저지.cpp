#include<iostream>
using namespace std;
char arr[1000001];
int j,a;
int answer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>j>>a;
	for(int i=1; i<=j; i++)
	cin>>arr[i];
	for(int i=0; i<a; i++)
	{
		char tmp; int temp;
		cin>>tmp>>temp;
		if(arr[temp]=='S')
		{
			if(tmp=='S')
			{
				arr[temp]='E';
				answer++;
			}
		}else if(arr[temp]=='M')
		{
			if(tmp=='M'||tmp=='S')
			{
				arr[temp]='E';
				answer++;
			}
		}else if(arr[temp]=='L')
		{
			if(tmp=='L'||tmp=='M'||tmp=='S')
			{
				arr[temp]='E';
				answer++;
			}
		}
	}
	cout<<answer;
}
