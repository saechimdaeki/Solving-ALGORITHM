#include<iostream>
using namespace std;

int arr[4][4];
string s;
int n,m,answer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	
	for(int i=0; i<n; i++)
	{
		cin>>s;
		for(int j=0; j<m; j++)
			arr[i][j]=s[j]-'0';			
	}		
	/*  가로는 0 세로는 1 비트마스크 (백준센세강의듣고 )  */		
	for (int s=0; s<(1<<(n*m)); s++) {
        int sum(0);
        for (int i=0; i<n; i++) {
            int current(0);
            for (int j=0; j<m; j++) {
                int k(i*m+j);
                if ((s&(1<<k)) == 0) {
                    current = current * 10 + arr[i][j];
                } else {
                    sum += current;
                    current = 0;
                }
            }
            sum += current;
        }
        for (int j=0; j<m; j++) {
            int current(0);
            for (int i=0; i<n; i++) {
                int k(i*m+j);
                if ((s&(1<<k)) != 0) {
                    current = current * 10 + arr[i][j];
                } else {
                    sum += current;
                    current = 0;
                }
            }
            sum += current;
        }
        answer = max(answer,sum);
    }
	cout<<answer;
			
}
