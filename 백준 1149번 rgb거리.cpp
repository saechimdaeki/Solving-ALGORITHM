#include<iostream>
#include<algorithm>
using namespace std;
int main()
{
	int dynamic[1001][3];
	int num;
	
	
	cin>>num;
	for(int i=1; i<=num; i++)
	{
		int red,green,blue;
		cin>>red>>green>>blue;
		dynamic[i][0]=min(dynamic[i-1][1],dynamic[i-1][2])+red;
		dynamic[i][1]=min(dynamic[i-1][0],dynamic[i-1][2])+green;
		dynamic[i][2]=min(dynamic[i-1][0],dynamic[i-1][1])+blue;
	}	
	cout<<min(min(dynamic[num][0],dynamic[num][1]),dynamic[num][2]);

		
} 
