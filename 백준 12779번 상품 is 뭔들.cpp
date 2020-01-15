#include<iostream>
#define endl '\n'
using namespace std;
long long gcd(long long a, long long b){
	if(b==0)
	return a;
	else
    return gcd(b,a%b);
}
long long cnt,a,b;
int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    cin>>a>>b;
    for(long long i=1; ; i++){
        long long i2 = i*i;
        if(i2 > b) break;
        if(i2 > a) cnt++;
    }
    long long bts = gcd(cnt, b-a);
    if(cnt/bts==0)
    cout<<"0";
    else
    cout<<cnt/bts<<'/'<<(b-a)/bts;
}
