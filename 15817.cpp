#include<cstdio>
#include<utility>

#define len first
#define own second

using namespace std;

int dp[100][10001];
pair<int, int> pipe[100];

int main()
{
	int N ,X;
	scanf("%d %d", &N, &X);
	 
	for(int i=0; i<N; ++i)
	{
		scanf("%d %d", &pipe[i].len, &pipe[i].own);
	}
	
	for(int i=0; i<=pipe[0].own; ++i)
	{
		if(pipe[0].len*i<=X) dp[0][pipe[0].len*i]=1;
	}
	
	for(int i=1; i<N; ++i)
	{
		for(int j=0; j<=X; ++j)
		{
			dp[i][j] = dp[i-1][j];
		}
		
		for(int j=0; j<=X; ++j)
		{
			if(dp[i-1][j])
			{
				for(int l=1; l<=pipe[i].own; ++l)
				{
					if(j+pipe[i].len*l<=X)
					{
						dp[i][j+pipe[i].len*l] += 1;
					}
				}
			}
		}
	}
	
	for(int i=0; i<N; ++i)
{
	for(int j=0; j<=X; ++j)
	{
		printf("%d", dp[i][j]);
	}
	printf("\n");
}

	printf("%d", dp[N-1][X]);
}
