#include<iostream>
using namespace std;
int dynamic[100001][3];
int n;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	dynamic[0][0]=1;
	/* dynamic[n][0] n번째줄에 배치x, dynamic[n][1] n번째줄 왼쪽배치 dynamic[n][2] n번째줄 오른쪽배치 */
	for(int i=1; i<=n; i++)
	{
		dynamic[i][0]=dynamic[i-1][0]+dynamic[i-1][1]+dynamic[i-1][2];
		dynamic[i][1]=dynamic[i-1][0]+dynamic[i-1][2];
		dynamic[i][2]=dynamic[i-1][0]+dynamic[i-1][1];
		for(int j=0; j<3; j++)
		dynamic[i][j]%=9901;
		
	}
	cout<<(dynamic[n][0]+dynamic[n][1]+dynamic[n][2])%9901;
	
}
