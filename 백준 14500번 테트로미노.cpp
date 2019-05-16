#include<iostream>
#include<algorithm>
using namespace std;
int a[500][500];
int result;
int poly[19][3][2]={
	
	{{0,1},{0,2},{0,3}},
	{{1,0},{2,0},{3,0}},
	{{1,0},{1,1},{1,2}},
	{{0,1},{1,0},{2,0}},
	{{0,1},{0,2},{1,2}},
	{{1,0},{2,0},{2,-1}},
	{{0,1},{0,2},{-1,2}},
	{{1,0},{2,0},{2,1}},
	{{0,1},{0,2},{1,0}},
	{{0,1},{1,1},{2,1}},
	{{0,1},{1,0},{1,1}},
	{{0,1},{-1,1},{-1,2}},
	{{1,0},{1,1},{2,1}},
	{{0,1},{1,1},{2,1}},
	{{1,0},{1,-1},{2,-1}},
	{{0,1},{0,2},{-1,1}},
	{{0,1},{0,2},{1,1}},
	{{1,0},{2,0},{1,1}},
	{{1,0},{2,0},{1,-1}},
	};
	
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int n, m;
	cin>>n>>m;
	for(int i=0; i<n; i++)
		for(int j=0; j<m; j++)
		cin>>a[i][j];
		
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			for(int k=0; k<19; k++)
			{
				bool ok=true;
				int sum=a[i][j];
				for(int l=0; l<3; l++)
				{
					int x=i+poly[k][l][0];
					int y=j+poly[k][l][1];
					if(0<=x && x<n && 0<=y &&y<m)
					{
						sum+=a[x][y];
					}else
					{
						ok=false;
						break;
					}
				}
				if(ok && result<sum)
				result=sum;			
			}		
		}
}
cout<<result<<"\n";

	}	


