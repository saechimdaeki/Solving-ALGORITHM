#include<iostream>
#define endl '\n'
#include<cstdio>
using namespace std;
int t;
int arr[500];
char carr[500];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	for(int i=0; i<t; i++)
	{
		int it;
		char ch;
		cin>>it>>ch;
		if(ch=='C')
		{
			for(int j=0; j<it; j++)
				cin>>carr[j];
			for(int j=0; j<it; j++)
				cout<<(int)carr[j]-64<<' ';
				cout<<endl;
		}else if(ch=='N'){
			for (int j=0; j<it; j++)
				cin>>arr[j];
			for(int j=0; j<it; j++)
				cout<<char(arr[j]-1+'A')<<' ';
				cout<<endl;
		}
		
	}

}
