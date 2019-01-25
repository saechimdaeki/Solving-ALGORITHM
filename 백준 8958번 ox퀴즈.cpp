#include<iostream>
#include<cstring>
using namespace std;

int main()
{
	char arr[80];
	int n;
	
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int sum(0);
	int score(1);
		scanf("%s",&arr[i]);
		for(int j=0; j<strlen(arr); j++)
		{
			if(arr[j]=='O')
			{
					sum+=score;
					score++;
			}	
			if(arr[j]=='X')
			score=1;
		}
	cout<<sum<<endl;		
	}	
} 
