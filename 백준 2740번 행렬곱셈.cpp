#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
int n1,m1,n2,m2;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n1>>m1;
	vector<vector<int> > v(n1, vector<int>(m1,0));
	for(int i=0; i<n1; i++)
		for(int j=0; j<m1; j++)
			cin>>v[i][j];
	cin>>n2>>m2;
	vector<vector<int> > v2(n2,vector<int>(m2,0));
	for(int i=0; i<n2; i++)
		for(int j=0; j<m2; j++)
			cin>>v2[i][j];
	vector<vector<int> > answer(n1,vector<int>(m2,0));
	for(int i=0; i<n1; i++)
	{
		for(int j=0; j<m2; j++)
		{
			for(int k=0; k<n2; k++)
			{
				answer[i][j] +=(v[i][k]* v2[k][j]);
			}		
		}		
	}
	for(int i=0; i<n1; i++)
		{
			for(int j=0; j<m2; j++)
			cout<<answer[i][j]<<' ';
			cout<<endl;	
		}
}
