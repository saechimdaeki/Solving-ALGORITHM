#include<iostream>
#include<algorithm>
using namespace std;
int n;
long long d[100001][4];
long long mod = 1000000009;
void dp()
{
	  for (int i = 1; i <= 100000; i++) {
        if (i - 1 >= 0) {
            d[i][1] = d[i - 1][2] + d[i - 1][3];
            if (i == 1)
			 d[i][1] = 1;
        }
        if (i - 2 >= 0) {
            d[i][2] = d[i - 2][1] + d[i - 2][3];
            if (i == 2) 
			d[i][2] = 1;
        }
        if (i - 3 >= 0) {
            d[i][3] = d[i - 3][1] + d[i - 3][2];
            if (i == 3) 
			d[i][3] = 1;
        }
        d[i][1] %= mod;
        d[i][2] %= mod;
        d[i][3] %= mod;
    }
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    cin >> n;
    dp();
    for(int i=0; i<n; i++){
        int a;
        cin >> a;
        cout<< (d[a][1] + d[a][2] + d[a][3]) % mod<<"\n";
    }
}
